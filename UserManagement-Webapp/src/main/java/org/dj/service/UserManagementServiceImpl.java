package org.dj.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dj.domain.UserAccount;
import org.dj.entity.CityEntity;
import org.dj.entity.CountryEntity;
import org.dj.entity.StateEntity;
import org.dj.entity.UserEntity;
import org.dj.repository.CityRepository;
import org.dj.repository.CountryRepository;
import org.dj.repository.StateRepository;
import org.dj.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Override
	public Map<Integer, String> getAllCountries() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
				
		List<CountryEntity> countriesList = countryRepo.findAll();
		countriesList.forEach(country -> {
			map.put(country.getCountryId(), country.getCountryName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getAllStates(Integer countryId) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		List<StateEntity> stateList = stateRepo.findAllByCountryId(countryId);
		stateList.forEach(state -> {
			map.put(state.getCountryId(), state.getStateName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getAllCities(Integer stateId) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
				
		List<CityEntity> cityList = cityRepo.findAllByStateId(stateId);
		cityList.forEach(city -> {
			map.put(city.getCityId(), city.getCityName());
		});
		return map;
	}

	@Override
	public String saveUserAccount(UserAccount account) {
		
		return null;
	}

	@Override
	public List<UserAccount> getAllUserAccount() {
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		UserAccount userAcc = new UserAccount();
		
		List<UserEntity> userEntities = userRepo.findAll();
		userEntities.forEach(userEnt -> {
			BeanUtils.copyProperties(userEnt, userAcc);
			userAccounts.add(userAcc);
		});
		
		return userAccounts;
	}

}
