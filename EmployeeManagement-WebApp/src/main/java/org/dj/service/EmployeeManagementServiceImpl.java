package org.dj.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.dj.dto.Address;
import org.dj.dto.Employee;
import org.dj.dto.Salary;
import org.dj.entity.AddressEntity;
import org.dj.entity.DistrictEntity;
import org.dj.entity.EmployeeEntity;
import org.dj.entity.SalaryEntity;
import org.dj.entity.StateEntity;
import org.dj.repository.DistrictRepository;
import org.dj.repository.EmployeeReopsitory;
import org.dj.repository.SalaryRepository;
import org.dj.repository.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private SalaryRepository salaryRepo;

	@Autowired
	private DistrictRepository distRepo;

	@Autowired
	private EmployeeReopsitory empRepo;

	@Override
	public Map<Integer, String> getAllState() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		List<StateEntity> stateEntities = stateRepo.findAll();
		stateEntities.forEach(state -> {
			map.put(state.getStateId(), state.getStateName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getDistByStateId(Integer stateId) {

		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		Optional<StateEntity> stateOptional = stateRepo.findById(stateId);

		if (stateOptional.isPresent()) {
			StateEntity stateEntity = stateOptional.get();

			stateEntity.getDistricts().forEach(dist -> {
				map.put(dist.getDistId(), dist.getDistName());
			});
			return map;
		}
		return map;
	}

	@Override
	public String saveEmployee(Employee employee) {
		
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, empEntity);

		SalaryEntity salaryEntity = new SalaryEntity();
		salaryEntity.setSalaryId(employee.getSalaryId());
		empEntity.setSalaryDtls(salaryEntity);

		AddressEntity addressEntity = new AddressEntity();
		Optional<StateEntity> stateOptional = stateRepo.findById(employee.getStateId());
		addressEntity.setStateName(stateOptional.get().getStateName());
		Optional<DistrictEntity> distOptional = distRepo.findById(employee.getDistId());
		addressEntity.setDistName(distOptional.get().getDistName());
		empEntity.setAddressDtsl(addressEntity);

		empEntity.setEmpRegId(EmployeeManagementServiceImpl.generateRandomString(10));
		
		EmployeeEntity savedEntity = empRepo.save(empEntity);

		return savedEntity.getEmpRegId();
	}

	@Override
	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		Optional<EmployeeEntity> empOptional = empRepo.findByEmpEmailAndEmpPassword(email, password);
		if (empOptional.isEmpty()) {
			return null;
		}
		EmployeeEntity employeeEntity = empOptional.get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		employee.setAddress(new Address());
		employee.setSalary(new Salary());
		BeanUtils.copyProperties(employeeEntity.getAddressDtsl(), employee.getAddress());
		BeanUtils.copyProperties(employeeEntity.getSalaryDtls(), employee.getSalary());

		return employee;
	}

	@Override
	public Map<Integer, String> getAllDesignation() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		Collection<SalaryEntity> salaryEntities = salaryRepo.findAll();

		salaryEntities.forEach(sal -> {
			map.put(sal.getSalaryId(), sal.getDesignation());
		});

		return map;
	}


	public static String generateRandomString(int length) {
		// define the symbols to choose from
		String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		// create a random object
		Random random = new Random();
		// create a string builder
		StringBuilder sb = new StringBuilder(length);
		// loop until the desired length is reached
		for (int i = 0; i < length; i++) {
			// get a random index of the symbols array
			int index = random.nextInt(symbols.length());
			// append the character at that index to the string builder
			sb.append(symbols.charAt(index));
		}
		// return the string
		return sb.toString();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> empEntityList = empRepo.findAll();
		List<Employee> empList = new ArrayList<Employee>();
		empEntityList.forEach(entity -> {
			Employee employee = new Employee();
			BeanUtils.copyProperties(entity, employee);
			employee.setAddress(new Address());
			employee.setSalary(new Salary());
			BeanUtils.copyProperties(entity.getAddressDtsl(),employee.getAddress());
			BeanUtils.copyProperties(entity.getSalaryDtls(),employee.getSalary());
			empList.add(employee);
		});
		return empList;
	}

}
