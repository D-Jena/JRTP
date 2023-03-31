package org.dj.service;

import java.util.List;
import java.util.Map;

import org.dj.domain.UserAccount;

public interface UserManagementService {
	Map<Integer, String> getAllCountries();
	Map<Integer, String> getStatesByCountryId(Integer countryId);
	Map<Integer, String> getCitiesByStateId(Integer stateId);
	String saveUserAccount(UserAccount account);
	List<UserAccount> getAllUserAccount();
}
