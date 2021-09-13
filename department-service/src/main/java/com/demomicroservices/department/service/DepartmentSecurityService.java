package com.demomicroservices.department.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DepartmentSecurityService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if (userName.equals("Subhadip")) {
			return new User("Subhadip", "Ayush12", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found..!!");
		}
	}
}
