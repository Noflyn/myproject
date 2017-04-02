package com.dresses.service;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.dresses.dao.CartItemDao;
import com.dresses.model.Cart;
import com.dresses.model.CartItem;

	@Service
	public class CartItemServiceImpl implements CartItemService{
		@Autowired
	private CartItemDao cartItemDao;
		
		
		public CartItemDao getCartItemDao() {
			return cartItemDao;
		}
		public void setCartItemDao(CartItemDao cartItemDao) {
			this.cartItemDao = cartItemDao;
		}
	   public void addCart1(CartItem cartItem) {
			cartItemDao.addCart(cartItem);
			
		}
		
		public void removeCartItem(int cartItemId) {
			cartItemDao.removeCartItem(cartItemId);		
		}

		public void removeAllCartItems1(Cart cart) {
			cartItemDao.removeAllCartItems(cart);
			
		}
		public void addCart(CartItem cartItem) {
			// TODO Auto-generated method stub
			
		}
		public void removeAllCartItems(Cart cart) {
			// TODO Auto-generated method stub
			
		}
	}

