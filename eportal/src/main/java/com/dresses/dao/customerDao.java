package com.dresses.dao;

import java.util.List;

import com.dresses.model.Customer;

public interface customerDao {
	boolean addCustomer(Customer c);
	boolean delCustomer(int id);
	boolean updCustomer(Customer c);
	Customer getCustomerByName(String name);
	List<Customer>getAllCustomer();
}
	


