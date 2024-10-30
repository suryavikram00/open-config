/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openapi.openconfig.service;

import com.api.open.crud.api.service.IOpenCrudService;
import com.openapi.openconfig.entity.UserEntity;

/**
 *
 * @author NMSLAP570
 */
public interface IUserService
        extends IOpenCrudService<UserEntity, Long> {
    
    public String generateToken(UserEntity authenticationRequest) throws Exception;

}
