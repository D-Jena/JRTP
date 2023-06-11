package org.dj.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state_master")
@Getter
@Setter
public class StateEntity {
	
	@Id
	private Integer stateId;
	
	private String stateName;
	
	@OneToMany(mappedBy = "state")
    private List<DistrictEntity> districts;
	
}
