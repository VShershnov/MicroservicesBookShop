package com.vshershnov.monolith.purchase.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vshershnov.monolith.delivery.domain.Customer;
import lombok.Data;

@Data
public class Order {
	private int id;
	
	private List<OrderItem> items;
	
	private LocalDateTime orderDate;
	
	private Customer customer;
	
	private boolean payed;
	
	private boolean delivered;
	
	private boolean cancelled;
	
	private LocalDateTime deliveryDate;
	
	private double deliveryPrice;

	public void addItem(OrderItem item) {
		if(items == null) {
			items = new ArrayList<>();
		}
		items.add(item);		
	}

}
