package com.demomicroservices.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomicroservices.department.entity.Department;
import com.demomicroservices.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//Method to save department object in database using Spring Data JPA

	public Department saveDepartment(Department department) 
	{	
		log.info("Inside saveDepartment Method of DepartmentService");
		return departmentRepository.save(department);
	}
	
	//Method to fetch the department details from database using Spring Data JPA
	
	public Department finDepartmentById(Long departmentId) 
	{
		log.info("Inside finDepartmentById Method of DepartmentService");
		Department department = departmentRepository.findByDepartmentId(departmentId);
		return department;
	}
	
}
