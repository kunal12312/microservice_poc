package com.demomicroservices.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demomicroservices.student.model.JWTRequest;
import com.demomicroservices.student.model.JWTResponse;
import com.demomicroservices.student.service.UserSecurityService;
import com.demomicroservices.student.utility.JWTUtility;

@RestController
public class StudentJWTController 
{
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<JWTResponse> authenticate(@RequestBody JWTRequest jwtRequest) throws Exception 
	{
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					jwtRequest.getUserName(),
					jwtRequest.getPassword()));
		} 
		catch (BadCredentialsException e) 
		{
			throw new Exception("Invalid Credentials", e);
		}
		
		final UserDetails userDetails = userSecurityService.loadUserByUsername(jwtRequest.getUserName());
		
		final String token = jwtUtility.generateToken(userDetails);
		System.out.println(token);
		
		return ResponseEntity.status(HttpStatus.OK).body(new JWTResponse(token));
	}
}
