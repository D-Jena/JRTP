package org.dj.controller;

import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeManagementController {
	
	@Autowired
	private EmployeeManagementService emService;
	
	@GetMapping("/employeeSignUp")
	public String lodeEmployeeSignUpForm(Model model) {
		
		Employee emp = new Employee();
		model.addAttribute("emp", emp);
		
		Map<Integer, String> allState = emService.getAllState();
		model.addAttribute("statesMap", allState);
		
		Map<Integer, String> allDesignation = emService.getAllDesignation();
		model.addAttribute("designations", allDesignation);
		
		return "employeeSignUpForm";
	}
	
	@PostMapping("/employeeSignUp")
	public String registerEmployee(@ModelAttribute("emp") Employee employee,
								   RedirectAttributes attributes) {
		
		String regId = emService.saveEmployee(employee);
		attributes.addFlashAttribute("successMsg","Registration successful. Your Registration ID is "+ regId);
		return "redirect:/home";
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
	public String employeeLogIn(@ModelAttribute("emp") Employee emp, Model model) {
		String email = emp.getEmpEmail();
		String password = emp.getEmpPassword();
		Employee employee = emService.getEmployeeByEmailAndPassword(email, password);
		
		if (employee == null) {
			model.addAttribute("failureMsg", "Invalid credential.");
			return "employeeLogInForm";
		}
		
		model.addAttribute("emp", employee);
		return "showEmployeeDtls";
	}
	
	@GetMapping("/getAllEmployee")
	public String getAllEmployees(Model model) {
		List<Employee> allEmployees = emService.getAllEmployees();
		model.addAttribute("employeeList",allEmployees);
		return "showAllEmployee";
	}
	
}
