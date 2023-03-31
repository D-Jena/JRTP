package org.dj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_mobile")
	private Long empMobile;
	
	@Column(name = "emp_email")
	private String empEmail;
	
	@Column(name = "emp_password")
	private String empPassword;
	
	@Column(name = "emp_reg_id")
	private String empRegId;
	
	private Integer salaryId;
	
	@Column(name = "join_date")
	private Date joinDate;
	
    private Integer addressId;
	
	@Column(name = "active")
	private boolean active;

}

