package org.dj.service;

import org.dj.entity.AdminEntity;
import org.dj.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

@Service
public class AdminAccessServiceImpl implements AdminAccessService {
	
	@Autowired
	private AdminRepository adminRepo;
		
	@Override
	public boolean authenticateAdmin(String email, String password) {

		AdminEntity adminEntity = adminRepo.findByEmailAndPassword(email, password);
		if (adminEntity == null) {
			return false;
		}
		return true;
	}

}
