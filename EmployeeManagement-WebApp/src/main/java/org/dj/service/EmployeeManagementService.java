package org.dj.service;

import java.util.List;
import java.util.Map;

import org.dj.dto.Employee;

public interface EmployeeManagementService {
	
	Map<Integer, String> getAllState();
	Map<Integer, String> getDistByStateId(Integer stateId);
	String saveEmployee(Employee emp);
	Employee getEmployeeByEmailAndPassword(String email, String password);
	Map<Integer, String> getAllDesignation();
	List<Employee> getAllEmployees();
	
}
