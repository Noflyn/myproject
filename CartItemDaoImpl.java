package com.dresses.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dresses.model.Cart;
import com.dresses.model.CartItem;

import antlr.collections.List;

@Repository
	public class CartItemDaoImpl implements CartItemDao {
		
		@Autowired
	private SessionFactory sessionFactory;
		
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		public void addCart(CartItem cartItem) {
			Session session=sessionFactory.openSession();
			session.saveOrUpdate(cartItem);
			session.flush();
			session.close();
			
		}public void removeCartItem(int cartItemId) {
			Session session=sessionFactory.openSession();
			CartItem cartItem=
				(CartItem)session.get(CartItem.class, cartItemId);
			session.delete(cartItem);
			session.flush();
			session.close();
		}

		public void removeAllCartItems1(Cart cart) {
			java.util.List<CartItem> cartItems=cart.getCartItems();
			for(CartItem cartItem:cartItems){
				removeCartItem(cartItem.getCartItemId());
			}
			
		}

		public void removeAllCartItems(Cart cart) {
			// TODO Auto-generated method stub
			
		}

	}


