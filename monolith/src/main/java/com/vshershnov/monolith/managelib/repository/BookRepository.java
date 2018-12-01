package com.vshershnov.monolith.managelib.repository;

import java.util.List;

import com.vshershnov.monolith.managelib.domain.Book;

public interface BookRepository {
	
	List<Book> getBooks();
	
	Book findBookById(int id);
	
	void saveBook(Book book);
	
	void deleteBook(int id);

}
