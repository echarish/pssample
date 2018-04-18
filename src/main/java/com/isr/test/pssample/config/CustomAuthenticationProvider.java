package com.isr.test.pssample.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.isr.test.pssample.model.Account;
import com.isr.test.pssample.repository.AccountRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	public CustomAuthenticationProvider(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		CustomAuthenticationToken customAuthenticationToken = (CustomAuthenticationToken) authentication;
		Account account = accountRepository.findByUsername((String) customAuthenticationToken.getPrincipal());

		if (account != null) {
			return authentication;
		} else {
			throw new UsernameNotFoundException(
					"could not find the user '" + customAuthenticationToken.getPrincipal() + "'");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthenticationToken.class.isAssignableFrom(authentication);
	}

}