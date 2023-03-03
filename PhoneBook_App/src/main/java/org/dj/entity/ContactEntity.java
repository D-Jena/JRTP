package org.dj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_DTLS")
public class ContactEntity {
	@Id
	@Column(name="CONTACT_ID")
	@SequenceGenerator(
			name="cid_seq",
			sequenceName="CONTACT_ID_SEQ",
			allocationSize=1
	)
	@GeneratedValue(
			generator="cid_seq",
			strategy=GenerationType.SEQUENCE
	)
	Integer contactId;
	
	@Column(name="CONTACT_NAME")
	String name;
	
	@Column(name="CONTACT_EMAIL")
	String email;
	
	@Column(name="CONTACT_NUMBER")
	Long phoneNo;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	Date updateDate;
}//class
