package org.dj.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.dj.dto.Employee;
import org.dj.entity.DistrictEntity;
import org.dj.entity.StateEntity;
import org.dj.repository.DistrictRepository;
import org.dj.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private DistrictRepository distRepo;

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
	  
	    List<DistrictEntity> distEntities = distRepo.findAllByStateId(stateId);
	    distEntities.forEach(dist -> {
	    map.put(dist.getDistId(), dist.getDistName());
	    });
	    return map;
	}
	
	
	@Override
	public String saveEmployee(Employee account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticateEmployee(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
