package com.vshershnov.monolith.delivery.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	private int id;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private String cardNumber;
	
	private List<Order> orders;

}
