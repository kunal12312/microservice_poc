package com.demomicroservices.department.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomicroservices.department.dtoModel.Department;
import com.demomicroservices.department.entity.DepartmentDto;
import com.demomicroservices.department.mapper.DepartmentMapper;
import com.demomicroservices.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService 
{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//Method to save department object in database using Spring Data JPA
	
	@Transactional
	public Department saveDepartment(Department department) 
	{	
		log.info("Inside saveDepartment Method of DepartmentService");
		
		DepartmentDto departmentDto = departmentRepository.save(departmentMapper.modelToDto(department));
		
		return departmentMapper.dtoToModel(departmentDto);
	}
	
	//Method to fetch the department details from database using Spring Data JPA
	
	public Department finDepartmentById(Long departmentId) 
	{
		log.info("Inside finDepartmentById Method of DepartmentService");
		DepartmentDto department = departmentRepository.findByDepartmentId(departmentId);
		return departmentMapper.dtoToModel(department);
	}
	
}
