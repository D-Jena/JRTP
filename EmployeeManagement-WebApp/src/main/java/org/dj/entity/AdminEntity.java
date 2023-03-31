package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "ADMIN")
public class AdminEntity {
	
	@Id
	private Integer id;
	private String password;
	private String email;
	
	
}
