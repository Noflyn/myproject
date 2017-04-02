package com.dresses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dresses.dao.CartDao;
import com.dresses.model.Cart;
import com.dresses.model.Customer;

	
	@Service
	public class CartServiceImpl implements CustomerService{
	@Autowired
	private CartDao cartDao;

		public CartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	public Cart getCartByCartId(int cartId) {
			return cartDao.getCartByCart(cartId);
		}
	public boolean addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean delCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean updCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}
	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	}

