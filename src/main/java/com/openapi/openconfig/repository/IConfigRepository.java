package com.openapi.openconfig.repository;

import com.api.open.crud.api.repository.OpenCrudApiRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.openapi.openconfig.entity.ConfigEntity;

/**
 *
 * @author NMSLAP570
 */
@Repository
@Transactional
public interface IConfigRepository 
  extends OpenCrudApiRepository<ConfigEntity, Long> {
  
}
