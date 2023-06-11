package org.dj.service;

import org.dj.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccessServiceImpl implements AdminAccessService {
	
	@Autowired
	private AdminRepository adminRepo;
		
	@Override
	public boolean authenticateAdmin(String userName, String password) {

		return adminRepo.findByuserNameAndPassword(userName, password).isPresent();
	}

}
