package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SalaryEntity {

	@Id
	private Integer salaryId;
	private Double basicSalary;
	private Double bonusSalary;
	private Double netSalary;
	private String designation;
	
}
