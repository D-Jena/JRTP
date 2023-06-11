package org.dj.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity {
	
	@Id
	@SequenceGenerator(name = "emp_seq", sequenceName = "empSeq", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
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
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "salaryId")	  
	private SalaryEntity salaryDtls;
	
	@Column(name = "join_date")
	private Date joinDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")	  
    private AddressEntity addressDtsl;
	
	@Column(name = "active")
	private boolean active;

}

