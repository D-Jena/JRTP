package org.dj.controller;

import java.util.Map;

import org.dj.dto.Employee;
import org.dj.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeManagementController {
	
	@Autowired
	private EmployeeManagementService emService;
	
	@GetMapping("/employeeSignUp")
	public String lodeEmployeeSignUpForm(Model model) {
		
		Employee emp = new Employee();
		Map<Integer, String> allState = emService.getAllState();
		
		model.addAttribute("emp", emp);
		model.addAttribute("statesMap", allState);
		return "employeeSignUpForm";
	}
	
	@PostMapping("/employeeSignUp")
	public String registerEmployee(@ModelAttribute("emp") Employee employee, Model model) {
		
		return "home";
	}
	
	@GetMapping("/getDistricts")
	@ResponseBody
	public Map<Integer, String> getDistricts(@RequestParam("sid") Integer stateId) {
				
		return emService.getDistByStateId(stateId);
	}

	@GetMapping("/employeeLogIn")
	public String lodeEmployeeLogInForm(Model model) {
		
		Employee emp = new Employee();
		model.addAttribute("emp", emp);
		return "employeeLogInForm";
	}
	
	@PostMapping("/employeeLogIn")
	public String employeeLogIn(@ModelAttribute("emp") Employee employee, Model model) {
		String email = employee.getEmpEmail();
		String password = employee.getEmpPassword();
		boolean isAuthenticated = emService.authenticateEmployee(email, password);
		
		if (!isAuthenticated) {
			model.addAttribute("msg", "Invalid credential.");
			return "employeeLogInForm";
		}
		return "showEmployeeDtls";
	}
	
}
