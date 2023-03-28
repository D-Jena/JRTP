package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CITIES_MASTER")
public class CityEntity {
	
	@Id
    private Integer cityId;
    private String cityName;
    private Integer stateId;
}

