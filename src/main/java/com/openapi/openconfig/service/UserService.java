/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openapi.openconfig.service;

import com.api.open.crud.api.entity.SimplePage;
import com.api.open.crud.api.service.OpenCrudService;
import com.openapi.openconfig.entity.UserEntity;
import com.openapi.openconfig.utility.JwtTokenUtils;
import com.openapi.openconfig.utility.UserPermissionUtility;

import java.util.ArrayList;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author NMSLAP570
 */
@Service
@Slf4j
public class UserService
        extends OpenCrudService<UserEntity, Long>
        implements IUserService {

    @Autowired
    JwtTokenUtils jwtTokenUtils;

    public String generateToken(UserEntity authenticationRequest) throws Exception {

        UserEntity user = new UserEntity();
        user.setEmail(authenticationRequest.getEmail());
        SimplePage<UserEntity> userPageList = super.findByValue(user, Pageable.unpaged(), Boolean.FALSE);
        UserEntity userDetails = userPageList.getContent() != null && userPageList.getContent().size() > 0
                ? userPageList.getContent().get(0) : null;
        if (Objects.isNull(userDetails)) {
            log.info("UserDetails is not present");
            throw new RuntimeException(UserPermissionUtility.EMAIL_NOT_REGISTERED);
        }

        if (!authenticationRequest.getPassword().equals(userDetails.getPassword())) {
            log.info("Password is incorrect");
            throw new RuntimeException(UserPermissionUtility.PASSWORD_INCORRECT);
        }

        String token = jwtTokenUtils.createJWT(userDetails);
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, new ArrayList<>()));
        return token;

    }

}
