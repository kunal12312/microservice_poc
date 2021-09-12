package com.demomicroservices.department.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.demomicroservices.department.dtoModel.Department;
import com.demomicroservices.department.entity.DepartmentDto;

@Mapper(componentModel = "spring")
public interface DepartmentMapper 
{
	DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
	
	Department dtoToModel(DepartmentDto departmentDto);
	
	DepartmentDto modelToDto(Department department);
	

}
