package org.dj.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Employee {
	
	private Integer empId;
	private String empName;
	private String empEmail;
	private Long empMobile;
	private String empDesignation;
	private String empRegId;
	private Integer salaryId;
	private Date joinDate;
	private String empPassword;
	private Integer stateId;
	private Integer distId;
}
