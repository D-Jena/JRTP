package org.dj.service;

import java.util.List;
import java.util.Map;

import org.dj.domain.UserAccount;

public interface UserManagementService {
	Map<Integer, String> getAllCountries();
	Map<Integer, String> getAllStates(Integer countryId);
	Map<Integer, String> getAllCities(Integer stateId);
	String saveUserAccount(UserAccount account);
	List<UserAccount> getAllUserAccount();
}
