package com.demomicroservices.student.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.demomicroservices.student.controller.StudentController;
import com.demomicroservices.student.entity.Student;
import com.demomicroservices.student.service.StudentService;
import com.demomicroservices.student.service.UserSecurityService;
import com.demomicroservices.student.utility.JWTUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StudentController.class)
class StudentControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService studentService;
	
	@MockBean
	public UserSecurityService userSecurityService;
	
	@MockBean
	public JWTUtility jwtUtility;
	
	@Test
	//@WithMockUser(username="Subhadip", password="Ayush2")
	void test_saveStudent() throws Exception {
		Student student=new Student(1001l,"Subhadip","Dutta","subhadip@xyz.com",10l);
		when(studentService.saveStudent(student)).thenReturn(student);
		String url="/student";
		mockMvc.perform(post(url)
				.content(asJsonString(student))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
		//.andExpect(content().);
	}
	public static String asJsonString(final Object obj) throws JsonProcessingException {
			return new ObjectMapper().writeValueAsString(obj);
	}
	
	@Test
	void getStudentWithDepartment() {
		
	}
	
	@Test
	void departmentServiceFallBackMethod() {
		
	}

}
