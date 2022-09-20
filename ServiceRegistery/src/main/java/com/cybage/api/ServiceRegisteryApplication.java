package com.cybage.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(scanBasePackages="com.cybage")	
@EnableEurekaServer
public class ServiceRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisteryApplication.class, args);
	}

}
