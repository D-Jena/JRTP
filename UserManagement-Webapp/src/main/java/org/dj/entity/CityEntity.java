package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CITY_MASTER")
public class CityEntity {
	
	@Id
    private Integer cityId;
    private String cityName;
    private Integer stateId;
}

