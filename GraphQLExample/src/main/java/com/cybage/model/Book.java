package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	private Integer id;
	private String title;
	private String publisher;
	private String[] author;
	private String publishedDate;
}
