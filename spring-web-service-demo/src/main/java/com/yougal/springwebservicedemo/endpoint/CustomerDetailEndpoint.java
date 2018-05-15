package com.yougal.springwebservicedemo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.yougal.schema.crm.Customer;
import com.yougal.schema.crm.CustomerRequest;
import com.yougal.schema.crm.CustomerResponse;

@Endpoint
public class CustomerDetailEndpoint {
	
	@PayloadRoot(localPart="CustomerRequest", namespace="http://www.yougal.com/schema/CRM")
	public @ResponsePayload CustomerResponse  getCustomer(@RequestPayload CustomerRequest customerRequest) {
		CustomerResponse customerResponse = new CustomerResponse();
		Customer customer = new Customer();
		customer.setCustId(customerRequest.getId());
		customer.setEmail("xyz@mail.com");
		customer.setName("Yougal");
		customer.setNotes("WS Tutorial");
		customer.setPhone("9711158646");
		customerResponse.setCustomer(customer);
		return customerResponse;
	}
	
}
