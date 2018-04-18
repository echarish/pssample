package com.isr.test.pssample.service.vo;

import java.util.Comparator;

public class UserCountObjectComparator implements Comparator<UserCountObject> {
	public int compare(UserCountObject c1, UserCountObject c2) {
		return c1.getUserId().compareTo(c2.getUserId());
	}
}
