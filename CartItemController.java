package com.dresses.controller;
import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dresses.model.Cart;
import com.dresses.model.CartItem;
import com.dresses.model.Customer;
import com.dresses.model.Product;
import com.dresses.service.CartItemService;
import com.dresses.service.CartServiceImpl;
import com.dresses.service.CustomerService;
import com.dresses.service.ProductService;



@Controller
public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private CartServiceImpl cartService;
	@Autowired	
	private CustomerService customerService;
	@Autowired	
	private ProductService productService;

	
	@RequestMapping("/cart/addcart/{id}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addToCart(@PathVariable(value="id") int id){
		
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=user.getUsername();
		Customer customer=customerService.getCustomerByName(username);
		System.out.println("Customer is " + customer.getCname() );
		Cart cart=customer.getCart();
		
		List<CartItem> cartItems=cart.getCartItems();
		Product product=productService.getbyid(id);
		for(int i=0;i<cartItems.size();i++){
			CartItem cartItem=cartItems.get(i);
			if(product.getId()==cartItem.getProduct().getId()){
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
				cartItemService.addCart(cartItem);
				return;
			}
		}
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(1);
		cartItem.setProduct(product);
		cartItem.setTotalPrice(product.getPrice() * 1);
		cartItem.setCart(cart);
		cartItemService.addCart(cartItem);
		}
	
	@RequestMapping("/cart/removecartitem/{cartItemId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeCartItem(
		@PathVariable(value="cartItemId") int cartItemId){
		cartItemService.removeCartItem(cartItemId);
	}

	@RequestMapping("/cart/removeAllItems/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@PathVariable(value="cartId") int cartId){
		Cart cart=cartService.getCartByCartId(cartId);
		cartItemService.removeAllCartItems(cart);
	}



}




