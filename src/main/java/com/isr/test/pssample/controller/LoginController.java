package com.isr.test.pssample.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isr.test.pssample.model.Login;
import com.isr.test.pssample.service.LoginService;
import com.isr.test.pssample.service.vo.UserCountObject;

@RestController
@RequestMapping("/test")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public List<Login> getLogin() {
		return loginService.getAllLogins();
	}

	@RequestMapping(value = "/dates", method = RequestMethod.GET)
	public List<String> getDates() {
		return loginService.getAllDates();
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<String> getUsers(@RequestParam(name = "start", required = false) String startDate,
			@RequestParam(name = "end", required = false) String endDate) {
		System.out.println("Get Users from start date " + startDate + " till End date " + endDate);
		return loginService.getUsers(startDate, endDate);
	}

	@RequestMapping(value = "/logins", method = RequestMethod.GET)
	public SortedSet<UserCountObject> getLogins(@RequestParam(name = "start", required = false) String startDate,
			@RequestParam(name = "end", required = false) String endDate,
			@RequestParam(name = "attribute1", required = false) List<String> attribute1List,
			@RequestParam(name = "attribute2", required = false) List<String> attribute2List,
			@RequestParam(name = "attribute3", required = false) List<String> attribute3List,
			@RequestParam(name = "attribute4", required = false) List<String> attribute4List) {
		return loginService.getAllLogins(startDate, endDate, attribute1List, attribute2List, attribute3List,
				attribute4List);
	}

}
