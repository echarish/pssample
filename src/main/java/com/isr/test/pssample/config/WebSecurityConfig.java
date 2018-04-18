package com.isr.test.pssample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
	// }

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.addFilterAt(new HeaderUsernamePasswordAuthenticationFilter(),
	// UsernamePasswordAuthenticationFilter.class)
	// .authorizeRequests().anyRequest().authenticated();
	// }
	//
	// @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception
	// {
	// return super.authenticationManagerBean();
	// }

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.addFilterBefore(new CustomAuthenticationFilter(), BasicAuthenticationFilter.class).authorizeRequests()
				.anyRequest().authenticated();

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

}
