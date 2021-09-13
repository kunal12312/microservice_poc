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
public class DepartmentDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private long departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "department_address")
	private String departmentAddress;
	
	@Column(name = "department_code")
	private String departmentCode;
	
}
