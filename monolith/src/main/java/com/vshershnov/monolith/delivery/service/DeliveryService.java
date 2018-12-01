package com.vshershnov.monolith.delivery.service;

import com.vshershnov.monolith.purchase.domain.Order;
import com.vshershnov.monolith.purchase.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
	private OrderRepository orderRepository;
	
	public void deliver(Order order) {
		order.setDelivered(true);
		
		orderRepository.save(order);
		System.out.println("Order delivered!");
	}

}
