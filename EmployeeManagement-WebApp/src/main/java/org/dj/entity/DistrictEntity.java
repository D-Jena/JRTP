package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "district_master")
@Getter
@Setter
public class DistrictEntity {
	
	@Id
	private Integer distId;
	
	private String distName;
	
	@ManyToOne
	@JoinColumn(name = "stateId")	    
	private StateEntity state;	 	    
					    
}
