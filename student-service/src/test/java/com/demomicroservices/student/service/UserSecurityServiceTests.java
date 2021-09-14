package com.demomicroservices.student.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Sunanda
 *
 */
@ExtendWith(SpringExtension.class)
class UserSecurityServiceTests {
	
	@InjectMocks
	private UserSecurityService userSecurityService;

	static String username=null;
	
	
	@BeforeAll
	public static void setup()throws Exception{
		
	}
	
	@AfterAll
	public static void tearDown() throws Exception{
		username=null;
	}
	/**
	 * tests loadUserByUsername() for valid username
	 */
	@Test
	void test_loadUserByUsername1() {
		username="Subhadip";
		UserDetails userDetails=new User("Subhadip", "Ayush12", new ArrayList<>());
		assertEquals(userDetails, userSecurityService.loadUserByUsername(username));
	}
	
	/**
	 * tests loadUserByUsername() for invalid username
	 */
	@Test
	void test_loadUserByUsername2() {
		username="Sudhanshu";
		Exception e=assertThrows(UsernameNotFoundException.class, ()->userSecurityService.loadUserByUsername(username));
		assertEquals("User not found..!!", e.getMessage());
	}
	
	/**
	 * tests loadUserByUsername() for null username
	 */
	@Test	//Not handled in UserSecurityService
	void test_loadUserByUsername3() {
		username=null;
		Exception e=assertThrows(UsernameNotFoundException.class, ()->userSecurityService.loadUserByUsername(username));
		assertEquals("Username is empty..!!", e.getMessage());
	}
	
}
