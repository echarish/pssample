package com.isr.test.pssample.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class HeaderUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Autowired
	static AuthenticationManager authenticationManager;

    /**
     * 
     */
    public HeaderUsernamePasswordAuthenticationFilter() {
        super();
        System.out.println(" Authentication Manager - "+ authenticationManager + BeanUtil.getBean(AuthenticationManager.class));
        this.setFilterProcessesUrl("/**");
        this.setPostOnly(false);
        this.setAuthenticationManager(BeanUtil.getBean(AuthenticationManager.class));
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#obtainPassword(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return request.getHeader(this.getPasswordParameter());
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#obtainUsername(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getHeader(this.getUsernameParameter());
    }   

}