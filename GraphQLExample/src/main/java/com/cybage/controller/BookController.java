package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.inputs.CreateBookInput;
import com.cybage.service.GraphQLService;
import com.cybage.service.MutationResolver;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/rest/books")
public class BookController {
	
	@Autowired
	private GraphQLService service;
	
	@Autowired
	private MutationResolver resolver;
	
	@PostMapping
	public ResponseEntity<Object> executeQuery(@RequestBody String query) {
		ExecutionResult result = service.getGraphQl().execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<Object> addBook(@RequestBody CreateBookInput bookInput){
		return new ResponseEntity<Object>(resolver.addBook(bookInput),HttpStatus.OK);
	}

}
