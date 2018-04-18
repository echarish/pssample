package com.isr.test.pssample.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isr.test.pssample.model.Login;
import com.isr.test.pssample.repository.LoginDataRepository;
import com.isr.test.pssample.service.vo.UserCountObject;
import com.isr.test.pssample.service.vo.UserCountObjectComparator;

@Service("loginservice")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDataRepository loginDataRepository;

	@Override
	public Login getLoginById(long id) {
		return loginDataRepository.findOne(id);
	}

	@Override
	public List<Login> getAllLogins() {
		return loginDataRepository.findAll();
	}

	@Override
	public List<String> getAllDates() {
		return loginDataRepository.getAllDates();
	}

	@Override
	public List<String> getUsers(String startDate, String endDate) {
		return loginDataRepository.getUsers(startDate, endDate);
	}

	@Override
	public SortedSet<UserCountObject> getAllLogins(String startDate, String endDate, List<String> attribute1List,
			List<String> attribute2List, List<String> attribute3List, List<String> attribute4List) {
		List<String> userList = loginDataRepository.getAllLogins(startDate, endDate, attribute1List, attribute2List,
				attribute3List, attribute4List);
		SortedSet<UserCountObject> countedUser = new TreeSet<>();
		int userCount = 0;
		String previousUser = null;
		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
			String currentUser = (String) iterator.next();
			if (StringUtils.isBlank(previousUser) || StringUtils.equals(previousUser, currentUser)) {
				userCount++;
			} else {
				UserCountObject countObject = new UserCountObject(previousUser, userCount);
				countedUser.add(countObject);
				userCount = 1;
			}
			previousUser = currentUser;
		}

		// Collections.sort(countedUserList, new UserCountObjectComparator());
		System.out.println(countedUser);
		return countedUser;
	}

}
