package com.example.kousik.demoswagger.employee;
import com.intuit.karate.junit5.Karate;

public class EmployeeTest {
	 @Karate.Test
	    Karate testGetEmployee() {
	        return Karate.run("get-employee-list").relativeTo(getClass());
	    }
}
 