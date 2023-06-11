package org.dj.controller;

import org.dj.dto.Admin;
import org.dj.service.AdminAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminAccessController {

	@Autowired
	private AdminAccessService aaService;
	
	@GetMapping(value = {"/", "home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/adminLogIn")
	public String loadAdminLogInForm(Model model) {
		
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "adminLogInForm";
	}
	
	@PostMapping("/adminLogIn")
	public String adminLogIn(@ModelAttribute("admin") Admin admin, Model model) {
		
		String userName = admin.getUserName();
		String password = admin.getPassword();
		boolean isAuthenticated = aaService.authenticateAdmin(userName, password);
		
		if (!isAuthenticated) {
			model.addAttribute("msg", "Invalid credential.");
			return "adminLogInForm";
		}
		return "redirect:/getAllEmployee";
	}
	
}
