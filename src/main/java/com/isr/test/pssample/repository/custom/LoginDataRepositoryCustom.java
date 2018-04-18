package com.isr.test.pssample.repository.custom;

import java.util.HashMap;
import java.util.List;

import com.isr.test.pssample.model.Login;

public interface LoginDataRepositoryCustom {
	
	List<String> getAllDates();

	List<String> getUsers(String startDate, String endDate);

	List<String> getAllLogins(String startDate, String endDate, List<String> attribute1List, List<String> attribute2List,
			List<String> attribute3List, List<String> attribute4List);

}
