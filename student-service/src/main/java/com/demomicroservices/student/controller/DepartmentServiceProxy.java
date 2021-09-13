package com.demomicroservices.student.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.demomicroservices.student.VO.Department;
import com.demomicroservices.student.model.JWTRequest;
import com.demomicroservices.student.model.JWTResponse;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentServiceProxy {
	@GetMapping("/departments/department/{id}")
	Department finDepartmentById(@RequestHeader("Authorization") String header, @PathVariable("id") Long departmentId);

	@PostMapping("/authenticate")
	JWTResponse authenticate(@RequestBody JWTRequest jwtRequest);
}
