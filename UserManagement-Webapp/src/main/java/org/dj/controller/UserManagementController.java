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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
       
        return "userAccountConfirmation";
    }
	
	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStatesByCountryId(@RequestParam("cid") Integer countryId) {
		
		Map<Integer, String> states = umService.getStatesByCountryId(countryId);;
		return states;
	}
	
	@GetMapping("/getCities")
	@ResponseBody
	public Map<Integer, String> getCitiesByStateId(@RequestParam("sid") Integer stateId) {
		
		Map<Integer, String> cities = umService.getCitiesByStateId(stateId);
		return cities;
	}
	
}
