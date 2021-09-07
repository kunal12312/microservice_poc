package com.demomicroservices.cloud.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//Using @EnableEurekaClient to register this application to the Eureka server
/*Using @EnableConfigServer to make this application as configuration server
*which will fetch the default configuration for all the services from git repository
*/

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServerApplication.class, args);
	}

}
