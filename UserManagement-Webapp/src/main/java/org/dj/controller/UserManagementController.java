package org.dj.controller;

import java.util.Map;

import org.dj.domain.UserAccount;
import org.dj.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserManagementController {
	
	@Autowired
	private UserManagementService umService;
	
	@GetMapping(value = {"/", "/lodeForm"})
	public String lodeForm(Model model) {
		
		UserAccount account = new UserAccount();
		model.addAttribute("userAcc", account);
		
		Map<Integer, String> countries = umService.getAllCountries();
		model.addAttribute("countries", countries);
		
		return "addUserForm";
	}
}
