package com.demomicroservices.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demomicroservices.student.entity.StudentDto;

@Repository
public interface StudentRepository extends JpaRepository<StudentDto, Long>
{

	StudentDto findByStudentId(Long studentId);

}
