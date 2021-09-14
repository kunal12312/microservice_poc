package com.demomicroservices.student.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;

import com.demomicroservices.student.repository.StudentRepository;
import com.demomicroservices.student.utility.JWTUtility;
import com.demomicroservices.student.entity.Student;
import com.demomicroservices.student.model.*;
import com.demomicroservices.student.controller.*;
import com.demomicroservices.student.VO.*;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Sunanda
 *
 */
@ExtendWith(SpringExtension.class)
class StudentServiceTests {

	@InjectMocks
	private StudentService studentService;
	
	@Mock
	private StudentRepository studentRepository;
	
	@Mock
	private JWTUtility jwtUtility;
	
	@Mock
	private UserSecurityService userSecurityService;
	
	@Mock
	private DepartmentServiceProxy departmentServiceProxy;
	
	static Student student=null;
	static String username=null;
	static long studentId=0L;
	static String valid_JwtToken=null;
	static String invalid_JwtToken=null;
	static String token=null;
	static UserDetails userDetails=null;
	static JWTRequest jwtRequest =null;
	static Department department=null;
	
	/**
	 * @throws Exception
	 */
	@BeforeAll
	public static void setup()throws Exception{
		student=new Student(1001L,"Subhadip","Dutta","subhadip@xyz.com",101L);
		username="Subhadip";
		studentId=1001L;
		valid_JwtToken="Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTdWJoYWRpcCIsImV4cCI6MTYzMTEwMTgxMSwiaWF0IjoxNjMxMDgzODExfQ.mNT5ytOLgp0reYxHiKzP2POWs-KGAhrgUlb96xV_CFFmRWnlwlynq0AI46ofXR9cBOg8loLZ8Vjh62eSH4B3Pg";	
		token=valid_JwtToken.substring(7);
		userDetails=new User("Subhadip", "Ayush12", new ArrayList<>());
		jwtRequest = new JWTRequest("Subhadip", "Ayush12");
		department=new Department(101L,"Computer Science & Engineering","Asansol Engineering College","CSE");
	}

	/**
	 * @throws Exception
	 */
	@AfterAll
	public static void tearDown() throws Exception{
		student=null;
		username=null;
		studentId=0L;
		valid_JwtToken=null;
		userDetails=null;
		jwtRequest =null;
		department=null;
	}
	
	/**
	 * tests saveStudent()
	 */
	@Test
	void test_saveStudent() {	
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals("Subhadip",studentService.saveStudent(student).getFirstName());
		verify(studentRepository).save(student);
	}
	
	/**
	 * tests getStudentWithDepartment() with valid studentId and valid JwtToken
	 */
	@Test
	void test_getStudentWithDepartment1() {	
		when(jwtUtility.getUsernameFromToken(token)).thenReturn(username);			
		when(userSecurityService.loadUserByUsername(username)).thenReturn(userDetails);	
		when(departmentServiceProxy.authenticate(any(JWTRequest.class))).thenReturn(new JWTResponse(token));		
		when(studentRepository.findByStudentId(studentId)).thenReturn(student);		
		when(departmentServiceProxy.finDepartmentById(valid_JwtToken, 101L)).thenReturn(department);		
		ResponseTemplateVO responseTemplateVO=studentService.getStudentWithDepartment(studentId, valid_JwtToken).getBody();
		//responseTemplateVO=null;
		assertEquals("Subhadip",responseTemplateVO.getStudent().getFirstName());
		assertEquals("Computer Science & Engineering",responseTemplateVO.getDepartment().getDepartmentName());
	}
	
	/**
	 * tests getStudentWithDepartment() with invalid studentId
	 */
	@Test
	void test_getStudentWithDepartment2() {	
		
		when(jwtUtility.getUsernameFromToken(token)).thenReturn(username);			
		when(userSecurityService.loadUserByUsername(username)).thenReturn(userDetails);	
		when(departmentServiceProxy.authenticate(any(JWTRequest.class))).thenReturn(new JWTResponse(token));		
		when(studentRepository.findByStudentId(studentId)).thenReturn(null);		
		ResponseEntity<ResponseTemplateVO> resEnt=studentService.getStudentWithDepartment(studentId, valid_JwtToken);
		assertEquals("400 BAD_REQUEST", resEnt.getStatusCode().toString());
		assertEquals(null, resEnt.getBody());
	}
}
