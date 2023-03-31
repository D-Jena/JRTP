package org.dj.service;

import java.util.Map;

import org.dj.dto.Employee;

public interface EmployeeManagementService {
	
	Map<Integer, String> getAllState();
	Map<Integer, String> getDistByStateId(Integer stateId);
	String saveEmployee(Employee account);
	boolean authenticateEmployee(String email, String password);
	
}
