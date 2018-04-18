package com.isr.test.pssample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;



@Entity
//@Table(name="account", schema="security")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "acc_id")
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	public Account() {
		super();
	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
