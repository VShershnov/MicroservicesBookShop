package com.vshershnov.monolith.purchase.domain;

import com.vshershnov.monolith.managelib.domain.Book;
import lombok.Data;

@Data
public class OrderItem {
	private final int bookId;
	private final int number;
}
