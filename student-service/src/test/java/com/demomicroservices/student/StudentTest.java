package com.demomicroservices.student;
import com.intuit.karate.junit5.Karate;

public class StudentTest {
	 @Karate.Test
	    Karate testGetStudent() {
	        return Karate.run("get-student").relativeTo(getClass());
	    }
}
 