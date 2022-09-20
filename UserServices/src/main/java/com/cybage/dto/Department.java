package com.cybage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	private Integer id;
	private String Name;
	private String address;
	private Integer Code;
	
}
