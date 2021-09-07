package com.demomicroservices.student.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department 
{
	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
