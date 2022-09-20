package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Department;
import com.cybage.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/add")
	public Department addDepartment(@RequestBody Department department){
		log.info("Inside department save method");
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable int id){
		log.info("Inside get department method");		
		return departmentService.getDepartmentById(id);
	}
}
