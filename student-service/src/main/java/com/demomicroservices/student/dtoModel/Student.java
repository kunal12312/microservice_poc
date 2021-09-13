package com.demomicroservices.student.dtoModel;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	@Id
	private Long studentId;

	// Student First Name should not be null or empty
	// Student First Name should have atleast 2 characters
	@NotEmpty(message = "Student First Name should not be null or empty")
	@Size(min = 2, message = "Student First Name should have atleast 2 characters")
	private String firstName;

	// Student Last Name should not be null or empty
	// Student Last Name should have atleast 2 characters
	@NotEmpty(message = "Student Last Name should not be null or empty")
	@Size(min = 2, message = "Student Last Name should have atleast 2 characters")
	private String lastName;

	// Student Email should not be null or empty
	// Student Email should be valid
	@NotEmpty(message = "Student Email should not be null or empty")
	@Email(message = "Student Email should be valid")
	private String email;

	// Student Department Id should not be null
	// Student Department Id should be atleast 1
	@NotNull(message = "Student Department Id should not be null or empty")
	@Min(value = 1, message = "Student Department Id should be atleast 1")
	private Long departmentId;

}
