package com.dresses.controller;
import org.apache.catalina.User;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dresses.service.CustomerService;
import com.dresses.model.Cart;
import com.dresses.model.Customer;
import com.dresses.service.CartServiceImpl;



	@Controller
	public class CartController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartServiceImpl cartService;

	public CartServiceImpl getCartService() {
		return cartService;
	}

	public void setCartService(CartServiceImpl cartService) {
		this.cartService = cartService;
	}

	public CustomerService getCustomerService() {
			return customerService;
		}

		public void setCustomerService(CustomerService customerServices) {
			this.customerService = customerServices;
		}

	@RequestMapping("/cart/getCartId")
	public String getCartId(Model model){
		User user=(User)SecurityConfig.getContext().getAuthentication().getPrincipal();
		String username=user.getUsername();
		Customer customer=customerService.getCustomerByName(username);
		System.out.println("dddddd......"+customer.getCart());
		model.addAttribute("cartId",customer.getCart().getCartId());
		return "Cart";
	}
	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCartItems(@PathVariable(value="cartId") int cartId){
		return cartService.getCartByCartId(cartId);
	}
	}



