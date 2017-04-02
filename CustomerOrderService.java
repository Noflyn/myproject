package com.dresses.service;

import com.dresses.model.CustomerOrder;

public interface CustomerOrderService {

	    void addCustomerOrder(CustomerOrder customerOrder);

	    double getCustomerOrderGrandTotal(int cartId);
	}

