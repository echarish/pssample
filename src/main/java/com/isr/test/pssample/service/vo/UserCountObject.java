package com.isr.test.pssample.service.vo;

public class UserCountObject implements Comparable<UserCountObject> {

	private String userId;
	private int loginCount;

	public UserCountObject(String userKey, int loginCount) {
		this.userId = userKey;
		this.loginCount = loginCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userKey) {
		this.userId = userKey;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int userLoginCount) {
		this.loginCount = userLoginCount;
	}

	@Override
	public String toString() {
		return this.getUserId() + ":" + this.getLoginCount();
	}

	@Override
	public int compareTo(UserCountObject another) {
		return this.getUserId().compareTo(another.getUserId());
	}

}
