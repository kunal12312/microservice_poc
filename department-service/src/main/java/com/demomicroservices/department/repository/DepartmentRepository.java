package com.demomicroservices.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demomicroservices.department.entity.DepartmentDto;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDto, Long> {

	DepartmentDto findByDepartmentId(Long departmentId);

}
