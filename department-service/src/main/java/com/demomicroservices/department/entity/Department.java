package com.demomicroservices.department.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private long departmentId;
	
	//Department Name should not be null or empty
	//Department Name should have atleast 2 characters
	@Column(name = "department_name")
	@NotEmpty(message = "Department Name should not be null or empty")
	@Size(min = 2, message = "Department Name should have atleast 2 characters")
	private String departmentName;
	
	//Department Address should not be null or empty
	@Column(name = "department_address")
	@NotEmpty(message = "Department Address should not be null or empty")
	private String departmentAddress;
	
	//Department Code should not be null or empty
	//Department Code should have atleast 6 characters
	@Column(name = "department_code")
	@NotEmpty(message = "Department Code should not be null or empty")
	@Size(min = 6, message = "Department Code should have atleast 6 characters")
	private String departmentCode;
	
}
