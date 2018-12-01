package com.vshershnov.monolith.purchase.repository;

import com.vshershnov.monolith.purchase.domain.Order;

public interface OrderRepository {
	
	void save(Order order);


	Order findById(int orderId);
}
