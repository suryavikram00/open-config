/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openapi.openconfig.controller;

import com.api.open.crud.api.controller.OpenCrudController;
import com.api.open.crud.api.exception.enums.StatusEnum;
import com.api.open.crud.api.exception.model.CrudApiResponse;
import com.openapi.openconfig.entity.UserEntity;
import com.openapi.openconfig.service.IUserService;
import com.openapi.openconfig.utility.UserPermissionUtility;

import static com.openapi.openconfig.constant.ConfigEndPoints.ENDPOINT_USER;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NMSLAP570
 */
@RestController
@Slf4j
@RequestMapping(path = ENDPOINT_USER)
@CrossOrigin("http://localhost:4200")
public class UserController
        extends OpenCrudController<UserEntity, Long> implements IUserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<CrudApiResponse<String>> createAuthenticationToken(@RequestBody UserEntity authenticationRequest)
            throws Exception {
        try {
            log.info("login request: {}", new JSONObject(authenticationRequest).toString());
            String token = userService.generateToken(authenticationRequest);
            if (Objects.isNull(token) || token.isEmpty()) {
                CrudApiResponse<String> crudApiResponse = new CrudApiResponse<String>(StatusEnum.FAILURE).addMessage("User logged in failed!");
                crudApiResponse.setObject(UserPermissionUtility.SOMETHING_WENT_WRONG);
                return new ResponseEntity(crudApiResponse, HttpStatus.UNAUTHORIZED);
            }
            CrudApiResponse<String> crudApiResponse = new CrudApiResponse<String>(StatusEnum.SUCCESS).addMessage("User logged in successfully");
            crudApiResponse.setObject(token);
            return new ResponseEntity(crudApiResponse, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.info("runtime exception : {}", e.getMessage());            
            CrudApiResponse<String> crudApiResponse = new CrudApiResponse<String>(StatusEnum.FAILURE).addMessage("User logged in failed!");
            crudApiResponse.setObject(e.getMessage());
            return new ResponseEntity(crudApiResponse, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            log.info("exception caught: {}", e.getMessage());            
            CrudApiResponse<String> crudApiResponse = new CrudApiResponse<String>(StatusEnum.FAILURE).addMessage("User logged in failed!");
            crudApiResponse.setObject(e.getMessage());
            return new ResponseEntity(crudApiResponse, HttpStatus.UNAUTHORIZED);
        }

    }

}
