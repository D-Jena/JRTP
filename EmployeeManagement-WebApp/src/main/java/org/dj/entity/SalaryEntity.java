package org.dj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "SALARY_INFO")
public class SalaryEntity {

	@Id
	private Integer salaryId;
	private Double basicSalary;
	private Double bonusSalary;
	private String designation;
	
}
