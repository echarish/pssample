package com.isr.test.pssample.service;

import java.util.List;
import java.util.SortedSet;

import com.isr.test.pssample.model.Login;
import com.isr.test.pssample.service.vo.UserCountObject;

public interface LoginService {

	Login getLoginById(long id);

	List<Login> getAllLogins();

	List<String> getAllDates();

	List<String> getUsers(String startDate, String endDate);

	SortedSet<UserCountObject> getAllLogins(String startDate, String endDate, List<String> attribute1List,
			List<String> attribute2List, List<String> attribute3List, List<String> attribute4List);

}
