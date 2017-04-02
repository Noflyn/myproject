package com.dresses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dresses.dao.CustomerOrderDao;
import com.dresses.model.Cart;
import com.dresses.model.CartItem;
import com.dresses.model.CustomerOrder;

import java.util.List;

	@Service
	public class CartService implements CustomerOrderService {

	    @Autowired
	    private CustomerOrderDao customerOrderDao;

	    @Autowired
	    private CartService cartService;

	    public void addCustomerOrder(CustomerOrder customerOrder) {
	        customerOrderDao.addCustomerOrder(customerOrder);
	    }

	    public double getCustomerOrderGrandTotal(int cartId) {
	        double grandTotal=0;
	        Cart cart = cartService.getCartByCartId(cartId);
	        List<CartItem> cartItems = cart.getCartItems();

	        for (CartItem item : cartItems) {
	            grandTotal+=item.getTotalPrice();
	        }

	        return grandTotal;
	    }
	}



