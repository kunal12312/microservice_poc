package com.demomicroservices.department.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demomicroservices.department.service.DepartmentSecurityService;

@RunWith(MockitoJUnitRunner.class)
class DepartmentSecurityServiceTest {

	@Mock
	private UserDetails userDetails;

	@InjectMocks
	private DepartmentSecurityService departmentSecurityService;

	@Test
	void loadUserByUsernameUnauthenticatedTest() {

		departmentSecurityService = new DepartmentSecurityService();

		String username = "Sudhanshu";

		// throwing exception for incorrect username
		Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
			departmentSecurityService.loadUserByUsername(username);
		});

		String expectedMessage = "User not found..!!";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void loadUserByUsernameAuthenticatedTest() {
		
		userDetails = new User("Subhadip", "Ayush12", new ArrayList<>());
		departmentSecurityService = new DepartmentSecurityService();
		String username = "Subhadip";
		assertEquals(departmentSecurityService.loadUserByUsername(username), userDetails);
	}
}
