package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AddressEntity {
	
	@Id
	private Integer addressId;
	
    private Integer stateId;
    
    private Integer distId;
    
}
