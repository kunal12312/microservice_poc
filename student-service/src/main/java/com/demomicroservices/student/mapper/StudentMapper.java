package com.demomicroservices.student.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.demomicroservices.student.dtoModel.Student;
import com.demomicroservices.student.entity.StudentDto;

@Mapper(componentModel = "spring")
public interface StudentMapper 
{
	StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);
	
	Student dtoToModel(StudentDto studentDto);
	
	StudentDto modelToDto(Student student);

}
