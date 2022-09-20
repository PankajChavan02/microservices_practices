package com.cybage.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cybage.model.Book;
import com.cybage.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GetByTitleFetcher implements DataFetcher<Book> {
	
	@Autowired
	private BookRepository repository;
	
	@Override
	public Book get(DataFetchingEnvironment environment) {
		return repository.findByTitle(environment.getArgument("title"));
	}
	

}
