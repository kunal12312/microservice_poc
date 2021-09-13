package com.demomicroservices.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demomicroservices.department.model.JwtRequest;
import com.demomicroservices.department.model.JwtResponse;
import com.demomicroservices.department.service.DepartmentSecurityService;
import com.demomicroservices.department.utility.JwtUtility;

@RestController
public class DepartmentJwtController {
	@Autowired
	private JwtUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DepartmentSecurityService departmentSecurityService;

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials", e);
		}

		final UserDetails userDetails = departmentSecurityService.loadUserByUsername(jwtRequest.getUserName());

		final String token = jwtUtility.generateToken(userDetails);
		System.out.println(token);

		return new JwtResponse(token);
	}
}
