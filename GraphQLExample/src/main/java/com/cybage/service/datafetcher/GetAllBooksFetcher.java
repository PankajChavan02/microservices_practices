package com.cybage.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cybage.model.Book;
import com.cybage.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetAllBooksFetcher implements DataFetcher<List<Book>> {
	
	@Autowired
	private BookRepository repository; 

	@Override
	public List<Book> get(DataFetchingEnvironment environment) {		
		return repository.findAll();
	}

}
