package com.dresses.service;

import java.util.List;

import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.dresses.dao.CustomerOrderDao;
import com.dresses.model.Cart;
import com.dresses.model.CartItem;
import com.dresses.model.CustomerOrder;


	@Service
	public class CustomerOrderserviceImpl implements CustomerOrderService {

	    @Autowired
	    private CustomerOrderDao customerOrderDao;

	    public void addCustomerOrder(CustomerOrder customerOrder) {
	        customerOrderDao.addCustomerOrder(customerOrder);
	    }

	    public double getCustomerOrderGrandTotal(int cartId) {
	        double grandTotal=0;
	        Cart cart = ContextService.getCartByCartId(cartId);
	        List<CartItem> cartItems = cart.getCartItems();

	        for (CartItem item : cartItems) {
	            grandTotal+=item.getTotalPrice();
	        }

	        return grandTotal;
	    }
	}

