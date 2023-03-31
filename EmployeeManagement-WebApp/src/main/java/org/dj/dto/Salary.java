package org.dj.dto;

import lombok.Data;

@Data
public class Salary {

	private Integer salaryId;
	private Double basicSalary;
	private Double bonusSalary;
	private Double netSalary;
	private String designation;
	
}
