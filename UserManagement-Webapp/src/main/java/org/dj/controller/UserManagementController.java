package org.dj.controller;

import java.util.Map;

import org.dj.domain.UserAccount;
import org.dj.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserManagementController {
	
	@Autowired
	private UserManagementService umService;
	
	@GetMapping(value = {"/", "/lodeForm"})
	public String lodeForm(Model model) {
		
		UserAccount account = new UserAccount();
		model.addAttribute("userAccount", account);
		
		Map<Integer, String> countries = umService.getAllCountries();
		model.addAttribute("countries", countries);
		
		return "addUserForm";
	}
	
	@PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("userAccount") UserAccount userAccount) {
        // process form data
        return "userAccountConfirmation";
    }
}
