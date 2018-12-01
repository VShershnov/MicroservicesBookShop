package com.vshershnov.monolith.delivery.repository;

import com.vshershnov.monolith.delivery.domain.Customer;

public interface CustomerRepository {
	
	Customer findById(int customerId);
	

}
