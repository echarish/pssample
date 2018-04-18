package com.isr.test.pssample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PssampleApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Autowired
	private MockHttpServletRequest request;

	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilters(springSecurityFilterChain)
				.build();
	}

	@Test
	public void testUserLogin() throws Exception {
		mockMvc.perform(get("/test/dates/").contentType(MediaType.ALL_VALUE).header("username", "isr")
				.header("password", "isr")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void testInvalidUserLogin() throws Exception {
		mockMvc.perform(get("/test/dates/").contentType(MediaType.ALL_VALUE).header("username", "dummy")
				.header("password", "dummy")).andExpect(MockMvcResultMatchers.status().is4xxClientError());

	}

	@Test
	public void testMissingAuthHeader() throws Exception {
		mockMvc.perform(get("/test/dates/").contentType(MediaType.ALL_VALUE))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());

	}

	// To wok with response
	// HttpSession session = mockMvc.perform....)
	// .andReturn().getRequest().getSession()
	//// request.setSession(session);
	//
	// SecurityContext securityContext = (SecurityContext) session
	// .getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
	//
	// SecurityContextHolder.setContext(securityContext);

}
