package com.demomicroservices.student.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomicroservices.student.VO.ResponseTemplateVO;
import com.demomicroservices.student.dtoModel.Student;
import com.demomicroservices.student.service.StudentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Student Service")
@RequestMapping("/students")
@Slf4j
public class StudentController {
	@Autowired
	private StudentService studentService;

	// Method to call the Service Class method to save student object in database

	@PostMapping("/student")
	@ApiOperation(value = "Save Student")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		log.info("Inside saveStudent Method of StudentController");

		Student savedStudent = studentService.saveStudent(student);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}

	// Method to call the Service Class method to fetch the student details with
	// department details
	// Implementing CircuitBreaker using @CircuitBrreaker

	@GetMapping("/student/{id}")
	@ApiOperation(value = "Get Student By id")
	@CircuitBreaker(name = "departmentService", fallbackMethod = "departmentServiceFallBackMethod")
	public ResponseEntity<ResponseTemplateVO> getStudentWithDepartment(@PathVariable("id") Long studentId,
			@RequestHeader HttpHeaders headers) {
		log.info("Inside getStudentWithDepartment Method of StudentController");

		final String jwtToken = headers.getFirst(HttpHeaders.AUTHORIZATION);

		return studentService.getStudentWithDepartment(studentId, jwtToken);
	}

	// Fall Back Method if department-service does not respond

	public ResponseEntity<String> departmentServiceFallBackMethod(Long studentId, HttpHeaders headers,
			Throwable exception) {
		// return "Department Service is down. Please try again later....";

		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("Department Service is Down. Please try again later..!!");
	}

}
