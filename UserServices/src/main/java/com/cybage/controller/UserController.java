package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.ResponseDto;
import com.cybage.model.User;
import com.cybage.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

	@Autowired	
	private UserService service;
	
	@GetMapping("/get")
	public ResponseEntity<?> get(){
		log.info("Inside demo get method of user micro-service");
		return new ResponseEntity<>("hello",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user){
		log.info("Inside add user method of user micro-service");
		return service.addUser(user); 
	}
	
//	@GetMapping("/{id}")
//	public User getUser(@PathVariable int id){
//		return service.getUserById(id);
//	}
	
	@GetMapping("/{id}")
	public ResponseDto getUserAndDepartment(@PathVariable Integer id){
		log.info("Inside get user method of user micro-service");
		return service.getUserAndDepartment(id);
	}
}
