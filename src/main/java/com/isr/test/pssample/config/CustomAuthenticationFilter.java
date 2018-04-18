package com.isr.test.pssample.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class CustomAuthenticationFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		
		System.out.println(" User Name and password from header is "+ username + ", " +password);
		

		// Create our Authentication and let Spring know about it
		Authentication auth = new CustomAuthenticationToken(username, password);
		SecurityContextHolder.getContext().setAuthentication(auth);

		filterChain.doFilter(request, response);

	}

}
