package com.demomicroservices.department.dtoModel;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
	@Id
	private long departmentId;

	// Department Name should not be null or empty
	// Department Name should have atleast 2 characters
	@NotEmpty(message = "Department Name should not be null or empty")
	@Size(min = 2, message = "Department Name should have atleast 2 characters")
	private String departmentName;

	// Department Address should not be null or empty
	@NotEmpty(message = "Department Address should not be null or empty")
	private String departmentAddress;

	// Department Code should not be null or empty
	// Department Code should have atleast 6 characters
	@NotEmpty(message = "Department Code should not be null or empty")
	@Size(min = 6, message = "Department Code should have atleast 6 characters")
	private String departmentCode;

}
