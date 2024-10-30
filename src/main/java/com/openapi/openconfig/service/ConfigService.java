package com.openapi.openconfig.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.api.open.crud.api.service.OpenCrudService;
import com.openapi.openconfig.entity.ConfigEntity;

/**
 *
 * @author NMSLAP570
 */
@Service
@Slf4j
public class ConfigService 
        extends OpenCrudService<ConfigEntity, Long>
        implements IConfigService {
  
}
