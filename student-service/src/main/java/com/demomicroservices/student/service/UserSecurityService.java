package com.demomicroservices.student.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService
{
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException 
	{
		//Logic to get the user from the Database
		if(userName!=null && !userName.isEmpty()) {
			if(userName.equals("Subhadip"))
			{
				return new User("Subhadip", "Ayush12", new ArrayList<>());
			}
			else 
			{
				throw new UsernameNotFoundException("User not found..!!");
			}
		}
		else
			throw new UsernameNotFoundException("Username is empty..!!");
		
	}

}
