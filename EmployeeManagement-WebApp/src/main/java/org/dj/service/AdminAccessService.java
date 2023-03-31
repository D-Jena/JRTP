package org.dj.service;

public interface AdminAccessService {
	
	boolean authenticateAdmin(String email, String password);
	
}
