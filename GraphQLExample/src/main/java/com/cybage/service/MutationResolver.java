package com.cybage.service;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.cybage.inputs.CreateBookInput;
import com.cybage.model.Book;
import com.cybage.repository.BookRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {
	
	@Autowired
	private BookRepository repository;
	
	public Book addBook(CreateBookInput bookInput) {
		return repository.save(new Book(null, bookInput.getTitle(), bookInput.getPublisher(), bookInput
				.getAuthor(),bookInput.getPublishedDate()));
	}

}
