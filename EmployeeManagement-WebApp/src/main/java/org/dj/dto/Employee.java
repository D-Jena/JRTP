package org.dj.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Employee {
	
	private Integer empId;
	private String empName;
	private String empEmail;
	private Long empMobile;
	private String empRegId;
	private Integer salaryId;
	private Salary salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate;
	private String empPassword;
	private Integer stateId;
	private Integer distId;
	private Address address;
}
