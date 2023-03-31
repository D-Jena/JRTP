package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "state_master")
public class StateEntity {
	
	@Id
	private Integer stateId;
	
	private String stateName;
	
}
