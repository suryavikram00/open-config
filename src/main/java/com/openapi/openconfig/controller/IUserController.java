/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openapi.openconfig.controller;

import com.api.open.crud.api.controller.IOpenCrudController;
import com.api.open.crud.api.exception.model.CrudApiResponse;
import com.openapi.openconfig.entity.UserEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author NMSLAP570
 */
public interface IUserController
        extends IOpenCrudController<UserEntity, Long> {

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<CrudApiResponse<String>> createAuthenticationToken(@RequestBody UserEntity authenticationRequest)
            throws Exception;

}
