package com.vshershnov.monolith.managelib.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Book {
	private int id;
	
	private String name;
	
	private int year;
	
	private int pages;
	
	private double price;
	
	private Person author;
	
	private List<Hit> hits = new ArrayList<>();	
}
