package com.cybage.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

	@RequestMapping("/userServiceFallBack")
	public String userServiceFallBackMethod(){
		return "User service is taking longer than expected"+
				"Please try again later";
	}
	
	@RequestMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod(){
		return "Department service is taking longer than expected"+
				"Please try again later";
	}
	
}
