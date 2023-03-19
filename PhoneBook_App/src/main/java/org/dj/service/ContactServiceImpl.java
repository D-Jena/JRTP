package org.dj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dj.entity.ContactEntity;
import org.dj.exception.PhoneBookException;
import org.dj.model.Contact;
import org.dj.repo.ContactDtlsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository contactRepo;
	
	@Override
	public boolean saveContact(Contact c) {
		boolean isSaved = false;
		try {	
			ContactEntity entity = new ContactEntity();
			BeanUtils.copyProperties(c, entity);
			ContactEntity savedEntity = contactRepo.save(entity);
			if (savedEntity != null) {
				isSaved = true;
			}
		} catch (Exception e) {
			throw new PhoneBookException("Save failed");
		}
		return isSaved;
	}

	@Override
	public List<Contact> getAllContact() {
		List<ContactEntity> entities;
		try {
			entities = contactRepo.findAll();
		} catch (Exception e) {
			throw new PhoneBookException("Something went wrong!");
		}
		
		//copy entity properties to model object
		//legacy approach
		/*List<Contact> contacts = new ArrayList<Contact>();
		for (ContactEntity entity : entities) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}*/
		
		//java 8 approach
		return entities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
	}
	

	@Override
	public boolean deleteContact(Integer cid) {
		try {
			contactRepo.deleteById(cid);
		} catch (Exception e) {
			throw new PhoneBookException("Deletion failed");
		}
		return true;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> optional = contactRepo.findById(cid);
		if (optional.isPresent()) {
			ContactEntity entity = optional.get();
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}
		return null;
	}
	
	public String getContactByEmail(String email) {
		List<ContactEntity> entity = contactRepo.findByEmail(email);
		if(!entity.isEmpty()) {
			return "duplicate";
		}
		return "unique";
	}

}//class
