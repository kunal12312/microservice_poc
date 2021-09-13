package com.demomicroservices.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class StudentDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "student_first_name")
	private String firstName;

	@Column(name = "student_last_name")
	private String lastName;

	@Column(name = "student_column")
	private String email;

	@Column(name = "student_department_id")
	private Long departmentId;

}
