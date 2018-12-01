package com.vshershnov.monolith.purchase.repository;

import java.util.HashMap;
import java.util.Map;

import com.vshershnov.monolith.purchase.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryOrderRepository implements OrderRepository{

	private final Map<Integer, Order> orders = new HashMap<>();

	private int counter;
	
	@Override
	public void save(Order order) {
		if(order.getId() == 0) {
			order.setId(++counter);
			orders.put(order.getId(), order);			
		} else {
			orders.put(order.getId(), order);
		}	
	}

	@Override
	public Order findById(int orderId) {
		return orders.get(orderId);
	}

}
