package com.cybage.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookInput {
	private String title;
	private String publisher;
	private String[] author;
	private String publishedDate;
}
