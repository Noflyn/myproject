package com.dresses.service;

import com.dresses.model.Cart;
import com.dresses.model.CartItem;

public interface CartItemService {
	void addCart(CartItem cartItem);
	void removeCartItem(int cartItemId);
	void removeAllCartItems(Cart cart);
	}


