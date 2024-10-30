package com.openapi.openconfig.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.open.crud.api.controller.OpenCrudController;

import com.openapi.openconfig.entity.ConfigEntity;
import static com.openapi.openconfig.constant.ConfigEndPoints.ENDPOINT_CONFIG;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = ENDPOINT_CONFIG)
// @CrossOrigin("${client.url}")
@CrossOrigin("http://localhost:4200")
public class ConfigController 
extends OpenCrudController<ConfigEntity, Long> implements IConfigController {
  
}
