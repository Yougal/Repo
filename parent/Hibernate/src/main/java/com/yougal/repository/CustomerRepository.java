package com.yougal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yougal.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Customer findById(Long id);
	
}
