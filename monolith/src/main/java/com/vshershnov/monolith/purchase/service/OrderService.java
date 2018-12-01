package com.vshershnov.monolith.purchase.service;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import com.vshershnov.monolith.purchase.domain.Order;
import com.vshershnov.monolith.purchase.domain.OrderItem;
import com.vshershnov.monolith.managelib.repository.BookRepository;
import com.vshershnov.monolith.delivery.repository.CustomerRepository;
import com.vshershnov.monolith.purchase.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;

	private final BookRepository bookRepository;

	private final CustomerRepository customerRepository;

	public void complete(int orderId) {
		Order order = orderRepository.findById(orderId);
		if (order != null) {
			order.setPayed(true);
			orderRepository.save(order);
		}
	}

	public void cancel(int orderId) {
		Order order = orderRepository.findById(orderId);
		if (order != null) {
			order.setCancelled(true);
			orderRepository.save(order);
		}
	}

	public Order createOrder(int bookId, int number, int customerId) {
		Order order = new Order();
		order.addItem(new OrderItem(bookRepository.findBookById(bookId).getId(), number));
		order.setOrderDate(LocalDateTime.now());
		order.setCustomer(customerRepository.findById(customerId));

		return order;
	}

	public void addBook(int orderId, int bookId, int number) {
		Order order = orderRepository.findById(orderId);
		if (order != null) {
			order.addItem(new OrderItem(bookRepository.findBookById(bookId).getId(), number));
			orderRepository.save(order);
		}
	}

}
