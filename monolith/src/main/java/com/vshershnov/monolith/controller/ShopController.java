package com.vshershnov.monolith.controller;

import java.util.List;

import com.vshershnov.monolith.managelib.domain.Book;
import com.vshershnov.monolith.purchase.service.OrderService;
import lombok.RequiredArgsConstructor;
import com.vshershnov.monolith.managelib.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {
	
	private String libraryName = "IT-Discovery library";
	
	private final BookRepository bookRepository;
	
	private final OrderService orderService;

	@GetMapping("/library")
	public String getLibraryName() {
		return libraryName;
	}

	@GetMapping("book")
	public List<Book> getBooks() {
		return bookRepository.getBooks();				
	}

	@GetMapping("book/{id}")
	public Book getBook(@PathVariable int id) {
		return bookRepository.findBookById(id);				
	}

	@PostMapping("book")
	public void saveBook(@RequestBody Book book) {
		bookRepository.saveBook(book);				
	}

	@PutMapping("book/{id}")
	public void updateBook(@RequestBody Book book) {
		bookRepository.saveBook(book);				
	}
	
	public int createOrder(int bookId, int number, int customerId) {
		return orderService.createOrder(bookId, number, customerId).getId();		
	}

	public void addBook(int orderId, int bookId, int number) {
		orderService.addBook(orderId, bookId, number);
	}
	
	public void completeOrder(int orderId) {
		orderService.complete(orderId);
	}
	
	public void deliver(int orderId) {
		orderService.deliver(orderId);			
	}
	
	public void cancel(int orderId) {
		orderService.cancel(orderId);
	}

}
