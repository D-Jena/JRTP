package org.dj.domain;


import java.util.Date;

import lombok.Data;

@Data
public class UserAccount {
	
    private String firstName;

    private String lastName;

    private Date DOB;

    private Character gender;

    private String userEmail;

    private Long userPhone;

    private Long countryId;

    private Long stateId;

    private Long cityId;
        
   
	    

}
