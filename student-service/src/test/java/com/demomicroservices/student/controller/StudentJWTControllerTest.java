package com.demomicroservices.student.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;

import com.demomicroservices.student.controller.StudentJWTController;
import com.demomicroservices.student.service.UserSecurityService;
import com.demomicroservices.student.utility.JWTUtility;
import com.demomicroservices.student.model.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentJWTController.class)
class StudentJWTControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JWTUtility jwtUtility;
	
	@MockBean
	private AuthenticationManager authenticationManager;
	
	@MockBean
	private UserSecurityService userSecurityService;

	@Test
	void test_authenticate() throws Exception {
		JWTRequest jwtRequest= new JWTRequest("Subhadip","Ayush12"); 
		String url="/authenticate";
		mockMvc.perform(post(url)).andExpect(status().isOk());
	}

}
