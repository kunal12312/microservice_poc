package com.demomicroservices.student.VO;

import com.demomicroservices.student.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO 
{
	private Student student;
	private Department department;
	
}