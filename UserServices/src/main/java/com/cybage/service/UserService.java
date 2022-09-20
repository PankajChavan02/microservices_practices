package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cybage.dto.Department;
import com.cybage.dto.ResponseDto;
import com.cybage.model.User;
import com.cybage.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private RestTemplate template;

	@Autowired
	private UserRepository repository;
	
	public User addUser(User user){
		System.out.println(user);
		return repository.save(user); 
	}
	
	public User getUserById(int id){
		return repository.findById(id).get();
	}
	
	public ResponseDto getUserAndDepartment(Integer userId){
		ResponseDto responseDto = new ResponseDto();
		User user = repository.findById(userId).get();
		System.out.println(user);
		if(user!=null){
			Department department = template.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(), Department.class);
		    responseDto.setDepartment(department);
		    responseDto.setUser(user);
		    return responseDto;
		}
		return null;
	}
}
