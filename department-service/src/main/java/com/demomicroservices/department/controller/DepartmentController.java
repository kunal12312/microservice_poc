package com.demomicroservices.department.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomicroservices.department.entity.Department;
import com.demomicroservices.department.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@RestController
@Api(value="Department Service")
@RequestMapping("/departments")
@Slf4j
public class DepartmentController 
{
	@Autowired
	private DepartmentService departmentService;
	
	//Method to call the Service Class method to save department object in database
	
	@PostMapping("/department")
	@ApiOperation(value = "Save Department")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department)
	{
		log.info("Inside saveDepartment Method of DepartmentController");
		
		Department savedDepartment = departmentService.saveDepartment(department);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
	}
	
	//Method to call the Service Class method to fetch the department details 
	
	@GetMapping("/department/{id}")
	@ApiOperation(value = "Get Department by id")
	public Department finDepartmentById(@PathVariable("id") Long departmentId)
	{
		log.info("Inside findDepartmentById Method of DepartmentController");
		return departmentService.finDepartmentById(departmentId);
	}
	
}


