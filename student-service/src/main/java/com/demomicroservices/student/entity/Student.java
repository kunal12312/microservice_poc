package com.demomicroservices.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_table")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long studentId;
	
	//Student First Name should not be null or empty
	//Student First Name should have atleast 2 characters
	@Column(name = "student_first_name")
	@NotEmpty(message = "Student First Name should not be null or empty")
	@Size(min = 2, message = "Student First Name should have atleast 2 characters")
	private String firstName;
	
	//Student Last Name should not be null or empty
	//Student Last Name should have atleast 2 characters
	@Column(name = "student_last_name")
	@NotEmpty(message = "Student Last Name should not be null or empty")
	@Size(min = 2, message = "Student Last Name should have atleast 2 characters")
	private String lastName;
	
	//Student Email should not be null or empty
	//Student Email should be valid
	@Column(name = "student_column")
	@NotEmpty(message = "Student Email should not be null or empty")
	@Email(message = "Student Email should be valid")
	private String email;
	
	//Student Department Id should not be null
	//Student Department Id should be atleast 1
	@Column(name = "student_department_id")
	@NotNull(message = "Student Department Id should not be null or empty")
	@Min(value = 1, message = "Student Department Id should be atleast 1")
	private Long departmentId;
	
}
