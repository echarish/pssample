package com.isr.test.pssample.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * This class represents the login table in db
 * 
 * @author pradeepsahu
 *
 */
@Entity
// @Table(name="login", schema="data")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "login_id")
	private long id;

	@Column(name = "login_time")
	private Timestamp loginTime;

	@Column(name = "user")
	private String user;

	@Column(name = "attribute1")
	private String attribute1;

	@Column(name = "attribute2")
	private String attribute2;

	@Column(name = "attribute3")
	private String attribute3;

	@Column(name = "attribute4")
	private String attribute4;

	public Login() {
		super();
	}

	public Login(String user, Timestamp loginTime, String attr1, String attr2, String attr3, String attr4) {
		super();
		this.user = user;
		this.loginTime = loginTime;
		this.attribute1 = attr1;
		this.attribute2 = attr2;
		this.attribute3 = attr3;
		this.attribute4 = attr4;
	}

	@Override
	public String toString() {
		return this.user + ", " + this.attribute1 + ", " + this.attribute2 + ", " + this.attribute3 + ", "
				+ this.attribute4 + ", " + this.loginTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonFormat(pattern = "yyyyMMdd")
	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loingTime) {
		this.loginTime = loingTime;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

}
