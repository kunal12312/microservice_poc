package com.example.kousik.demoswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.kousik.demoswagger.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	//@Query("select e from Employee e,address a where e.id=a.emp_id and a.city=?1")
	public Employee findEmployeeByAddress_City(String city);
	//public Employee findEmployeeByAddress_City(String firstName,String lastName);

}