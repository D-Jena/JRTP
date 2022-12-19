package org.dj.controller;

import org.dj.model.Contact;
import org.dj.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("Contact",c);
		return "addContact";
	}

}
