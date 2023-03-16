package org.dj.controller;

import org.dj.model.Contact;
import org.dj.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class ViewContactController {

	@Autowired
	ContactService contactService;
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer cid, Model model) {
		Contact contact = contactService.getContactById(cid);
		model.addAttribute("contact", contact);
		return "addContact";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid) {
		System.out.println("ViewContactController.deleteContact()");
		boolean isDeleted = contactService.deleteContact(cid);
		if (isDeleted) {
			return "redirect:/viewContacts";
		}
		
		return null;
	}
}//class
