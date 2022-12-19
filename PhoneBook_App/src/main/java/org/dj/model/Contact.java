package org.dj.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Contact {

	String name;
	int contactId;
	String email;
	long phoneNo;
	Date createDate;
	Date updateDate;
}//class

