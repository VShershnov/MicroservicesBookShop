package com.vshershnov.monolith.managelib.controller;

import java.util.List;

import com.vshershnov.monolith.managelib.domain.Book;
import lombok.RequiredArgsConstructor;
import com.vshershnov.monolith.managelib.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library")
@RequiredArgsConstructor
public class LibController {
	
	private String libraryName = "IT-Discovery library";
	
	private final BookRepository bookRepository;

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

}
