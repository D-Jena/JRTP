package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
public class AddressEntity {
	
	@Id
	@SequenceGenerator(name = "address_seq", sequenceName = "Address_Seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	private Integer addressId;

    private String stateName;
    
    private String distName;
    
}
