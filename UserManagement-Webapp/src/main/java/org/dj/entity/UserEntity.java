package org.dj.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_ENTITY")
public class UserEntity {

    @Id
    @SequenceGenerator(
			name="USER_ID_SEQ",
			allocationSize=1
	)
	@GeneratedValue(
			generator="USER_ID_SEQ",
			strategy=GenerationType.SEQUENCE
	)
    private Integer userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date DOB;

    private Character gender;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false, unique = true)
    private Long userPhone;

    @Column(nullable = false)
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Integer countryId;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private Long stateId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Integer cityId;
    
    @Column
	private String accountStatus = "LOCKED";
    
    @CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="created_date", updatable = false)
	Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="updated_date", insertable = false)
	Date updatedDate;
	    
}//class