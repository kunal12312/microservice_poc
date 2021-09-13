package com.demomicroservices.department;
import com.intuit.karate.junit5.Karate;

public class DepartmentTest {
	 @Karate.Test
	    Karate testGetDepartment() {
	        return Karate.run("get-department").relativeTo(getClass());
	    }
}
 