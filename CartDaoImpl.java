package com.dresses.dao;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.dresses.model.Cart;

	@Repository
	public class CartDaoImpl implements CartDao{
		@Autowired
	private SessionFactory sessionFactory;

		public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Cart getCartByCartId(int cartId) {
			Session session=sessionFactory.openSession();
			Cart cart=(Cart)session.get(Cart.class, cartId);
			System.out.println(cart.getCartId() + " " + cart.getCartItems());
			return cart;
	}
	public Cart getCartByCart(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}
	}

	


