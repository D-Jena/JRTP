package org.dj.controller;

import java.util.List;

import org.dj.model.Contact;
import org.dj.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = {"/", "/addContact"})
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact",c);
		return "addContact";
	}
	
	@PostMapping("/saveContact")
	public String handleSbmtBtn(@ModelAttribute("contact") Contact c, Model model) {
		boolean isSaved = contactService.saveContact(c);
		if(isSaved)
			model.addAttribute("succMsg", "Contact saved");
		else 
			model.addAttribute("errMsg", "Faild to save contact");
		
		return "redirect:/viewContacts";
		
	}
	
	@GetMapping("/viewContacts")
	public String handleViewContactsLink(Model model) {
		List<Contact> contactList = contactService.getAllContact();
		model.addAttribute("contacts", contactList);
		return "viewContacts";
	}
	
	

}//class
