package org.dj.service;

import java.util.List;

import org.dj.model.Contact;

public interface ContactService {

	boolean saveContact(Contact c);
	
	List<Contact> getAllContact();
	
	Contact getContactById(Integer cid); 
	
	String getContactByEmail(String email);
	
	boolean deleteContact(Integer cid);
}
