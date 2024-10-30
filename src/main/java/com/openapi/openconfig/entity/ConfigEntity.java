package com.openapi.openconfig.entity;

import com.api.open.crud.api.entity.BaseEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "config")
@Data
public class ConfigEntity extends BaseEntity<Long>
implements Serializable {

private static final long serialVersionUID = 1L;
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
@NaturalId
private Long id;

@Column(name = "name")
private String name;

@Column(name = "value")
private String value;

@Column(name = "description")
private String description;

@Override
public String updatedByColumn() {
return "";
}

@Override
public String updatedOnColumn() {
return "";
}

@Override
public String createdByColumn() {
return "";
}

@Override
public String createdOnColumn() {
return "";
}
  
}
