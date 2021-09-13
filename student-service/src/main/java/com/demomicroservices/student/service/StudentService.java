package com.demomicroservices.student.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.demomicroservices.student.VO.Department;
import com.demomicroservices.student.VO.ResponseTemplateVO;
import com.demomicroservices.student.controller.DepartmentServiceProxy;
import com.demomicroservices.student.dtoModel.Student;
import com.demomicroservices.student.entity.StudentDto;
import com.demomicroservices.student.mapper.StudentMapper;
import com.demomicroservices.student.model.JWTRequest;
import com.demomicroservices.student.model.JWTResponse;
import com.demomicroservices.student.repository.StudentRepository;
import com.demomicroservices.student.utility.JWTUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private DepartmentServiceProxy departmentServiceProxy;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private UserSecurityService userSecurityService;

	// Method to save student object in database using Spring Data JPA

	@Transactional
	public Student saveStudent(Student student) {
		log.info("Inside saveStudent Method of StudentService");

		StudentDto studentDto = studentRepository.save(studentMapper.modelToDto(student));
		return studentMapper.dtoToModel(studentDto);
	}

	// Method to fetch the student details with department details from database
	// using Spring Data JPA
	// ResponseTemplateVO Class object holds the Student and Department Object

	public ResponseEntity<ResponseTemplateVO> getStudentWithDepartment(Long studentId, String JwtToken) {
		log.info("Inside getStudentWithDepartment Method of StudentService");

		String username = null;
		String token = null;

		if (null != JwtToken && JwtToken.startsWith("Bearer ")) {
			token = JwtToken.substring(7);
			username = jwtUtility.getUsernameFromToken(token);
		}

		UserDetails userDetails = userSecurityService.loadUserByUsername(username);
		final JWTRequest jwtRequest = new JWTRequest(userDetails.getUsername(), userDetails.getPassword());

		// POC
		System.out.println(jwtRequest.getUserName() + " " + jwtRequest.getPassword());

		// Calling the DEPARTMENT-SERVICE to get the authentication token

		final JWTResponse jwtResponse = departmentServiceProxy.authenticate(jwtRequest);

		// POC
		System.out.println(jwtResponse.getJwtToken());

		final String authenticationToken = "Bearer " + jwtResponse.getJwtToken();

		// POC
		System.out.println(authenticationToken);

		ResponseTemplateVO vo = new ResponseTemplateVO();
		StudentDto studentDto = studentRepository.findByStudentId(studentId);

		// Calling the DEPARTMENT-SERVICE to get the department details with specified
		// department ID

		Department department = departmentServiceProxy.finDepartmentById(authenticationToken,
				studentDto.getDepartmentId());

		vo.setStudent(studentMapper.dtoToModel(studentDto));
		vo.setDepartment(department);

		return ResponseEntity.status(HttpStatus.OK).body(vo);

	}

}
