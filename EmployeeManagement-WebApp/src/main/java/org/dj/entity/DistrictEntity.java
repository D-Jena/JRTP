package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "district_master")
public class DistrictEntity {
	
	@Id
	private Integer distId;
	
	private String distName;
	
	private Integer stateId;
					    
}
