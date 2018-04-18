package com.isr.test.pssample.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2099969521939618371L;

	public CustomAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	

}
