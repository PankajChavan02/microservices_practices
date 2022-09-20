package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByTitle(String argument);

}
