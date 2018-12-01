package com.vshershnov.monolith.purchase.controller;

import com.vshershnov.monolith.purchase.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("purchase")
@RequiredArgsConstructor
public class PurchaseController {
	
	private String libraryName = "IT-Discovery library";

	private final OrderService orderService;

	@PostMapping("order")
	public int createOrder(int bookId, int number, int customerId) {
		return orderService.createOrder(bookId, number, customerId).getId();		
	}

	@PutMapping("order/{orderId}/addbook/{bookId}/{number}")
	public void addBook(@PathVariable("orderId") int orderId,
						@PathVariable("bookId") int bookId,
						@PathVariable("number") int number) {
		orderService.addBook(orderId, bookId, number);
	}

	@PostMapping("book")
	public void completeOrder(int orderId) {
		orderService.complete(orderId);
	}

	public void cancel(int orderId) {
		orderService.cancel(orderId);
	}
}
