package com.vshershnov.monolith.managelib.domain;

import java.time.LocalDate;
import java.util.List;

import com.vshershnov.monolith.analytic.domain.Hit;
import lombok.Data;

@Data
public class Person {
	private int id;
	
	private String name;
	
	private String biography;
	
	private List<Book> books;
	
	private LocalDate birthDate;
	
	private List<Hit> hits;

}
