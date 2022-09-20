package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Department;
import com.cybage.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department addDepartment(Department department){
		return departmentRepository.save(department);
	}
	
	public Department getDepartmentById(int id){
		return departmentRepository.findById(id).get();
	}
}
