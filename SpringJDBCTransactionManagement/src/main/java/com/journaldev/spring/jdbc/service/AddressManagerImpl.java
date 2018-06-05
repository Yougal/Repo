package com.journaldev.spring.jdbc.service;

import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.jdbc.dao.AddressDAO;
import com.journaldev.spring.jdbc.model.Address;

public class AddressManagerImpl implements AddressManager {

	private AddressDAO addressDAO;



	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}



	@Override
	@Transactional
	public void createAddress(Address address) throws Exception {
		addressDAO.create(address);
		throw new RuntimeException("Hello Error");
	}

}
