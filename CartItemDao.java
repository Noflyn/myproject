package com.dresses.dao;

import com.dresses.model.Cart;
import com.dresses.model.CartItem;

public interface CartItemDao {
	void addCart(CartItem cartItem);

	void removeCartItem(int cartItemId);
	void removeAllCartItems(Cart cart);
	}


