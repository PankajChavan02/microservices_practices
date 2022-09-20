package com.cybage.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cybage.model.Book;
import com.cybage.repository.BookRepository;
import com.cybage.service.datafetcher.GetAllBooksFetcher;
import com.cybage.service.datafetcher.GetByTitleFetcher;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	
	private GraphQL graphQl;

	 @Value("classpath:books.graphql")
	 Resource resource;
	 
	 @Autowired
	 private BookRepository repository;
	
	 
	 @Autowired
	 private GetAllBooksFetcher getAllBooksFetcher;
	 
	 @Autowired
	 private GetByTitleFetcher getByTitleFetcher;
	
	 @PostConstruct
	private void loadSchema() throws IOException {
		loadDataIntoHSQL();
		File file = resource.getFile();
		TypeDefinitionRegistry registery = new SchemaParser().parse(file);
		RuntimeWiring wiring = buildWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registery, wiring);
		graphQl = GraphQL.newGraphQL(schema).build();
		
	}
	 
	 private void loadDataIntoHSQL() {

	        Stream.of(
	                new Book(123, "Book of Clouds", "Kindle Edition",
	                        new String[] {
	                        "Chloe Aridjis"
	                        }, "Nov 2017"),
	                new Book(124, "Cloud Arch & Engineering", "Orielly",
	                        new String[] {
	                                "Peter", "Sam"
	                        }, "Jan 2015"),
	                new Book(125, "Java 9 Programming", "Orielly",
	                        new String[] {
	                                "Venkat", "Ram"
	                        }, "Dec 2016")
	        ).forEach(book -> {
	            repository.save(book);
	        });
	    }

	private RuntimeWiring buildWiring() {
		
		DataFetcher<Book> fetcher1 = data->{
			return repository.findById(data.getArgument("id")).get();
		};
		
		return RuntimeWiring.newRuntimeWiring().
				type("Query",typeWiring->typeWiring
						.dataFetcher("getAllBooks", getAllBooksFetcher)
						.dataFetcher("getByTitle", getByTitleFetcher)
						.dataFetcher("getById", fetcher1)
						
						
						)						
				.build();						
	}
	
	public GraphQL getGraphQl() {
		return this.graphQl;
	}
}
