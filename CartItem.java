package com.dresses.model;

import javax.persistence.*;
import java.io.Serializable;


	@Entity
	public class CartItem implements Serializable{

	    private static final long serialVersionUID = -904360230041854157L;

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int cartItemId;

	    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinColumn(name = "cartId")
	    private Cart cart;

	    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinColumn(name = "id")
	    private Product product;

	    private int quantity;
	    private double totalPrice;

	    public int getCartItemId() {
	        return cartItemId;
	    }

	    public void setCartItemId(int cartItemId) {
	        this.cartItemId = cartItemId;
	    }

	    public Cart getCart() {
	        return cart;
	    }

	    public void setCart(Cart cart) {
	        this.cart = cart;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }
	}


