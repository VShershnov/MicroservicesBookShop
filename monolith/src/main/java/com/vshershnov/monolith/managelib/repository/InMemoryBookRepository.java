package com.vshershnov.monolith.managelib.repository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vshershnov.monolith.analytic.domain.Hit;
import com.vshershnov.monolith.managelib.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookRepository implements BookRepository {
	private static final String APP_NAME = "Monolith client";

	private final Map<Integer, Book> books;

	private int counter;

	public InMemoryBookRepository() {
		books = new HashMap<>();
		Book book = new Book();
		book.setId(++counter);
		book.setName("Thinking in Java");
		book.setPages(1150);
		book.setYear(2006);
		books.put(book.getId(), book);
	}

	@Override
	public List<Book> getBooks() {
		return new ArrayList<>(books.values());
	}
	
	private void addHit(Book book) {
		Hit hit = new Hit();
		hit.setBrowser("Chrome");
		try {
			hit.setIp(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		hit.setUserName(System.getProperty("user.name"));
		hit.setViewed(LocalDateTime.now());
		hit.setApplicationName(APP_NAME);
		book.getHits().add(hit);		
	}

	@Override
	public Book findBookById(int id) {
		Book book =  books.get(id);
		if(book != null) {
			addHit(book);
		}
		
		return book;
	}

	@Override
	public void saveBook(Book book) {
		if(book.getId() == 0) {
			book.setId(++counter);
			books.put(book.getId(), book);			
		} else {
			books.put(book.getId(), book);
		}	
	}

	@Override
	public void deleteBook(int id) {
		books.remove(id);
	}

}
