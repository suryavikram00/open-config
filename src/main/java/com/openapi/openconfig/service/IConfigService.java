package com.openapi.openconfig.service;

import com.api.open.crud.api.service.IOpenCrudService;
import com.openapi.openconfig.entity.ConfigEntity;

public interface IConfigService 
  extends IOpenCrudService<ConfigEntity, Long> {    
  
}
