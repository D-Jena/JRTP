package org.dj.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	Date updateDate;
}//class
