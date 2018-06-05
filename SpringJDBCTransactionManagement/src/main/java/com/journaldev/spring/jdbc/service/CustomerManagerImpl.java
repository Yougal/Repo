package com.journaldev.spring.jdbc.service;

import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.jdbc.dao.CustomerDAO;
import com.journaldev.spring.jdbc.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	
	private AddressManager addressManager;
	private CustomerDAO customerDAO;


	@Override
	@Transactional
	public void createCustomer(Customer cust) throws Exception{
		try{
			customerDAO.create(cust);
			addressManager.createAddress(cust.getAddress());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	public void setAddressManager(AddressManager addressManager) {
		this.addressManager = addressManager;
	}
	

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
