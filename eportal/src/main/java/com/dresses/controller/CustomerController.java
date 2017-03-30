package com.dresses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dresses.dao.customerDao;
import com.dresses.model.Customer;
import com.dresses.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	customerDao cs;
	//CustomerService cs;
	@ModelAttribute("cust")
	public Customer getcustomer(){
		return new Customer();
	}
	@RequestMapping("/addCustomer")
			public String saveCustomer(@ModelAttribute Customer c){
		if(cs.addCustomer(c))
			
				{
			return "welcome";
				}
		else{
			return "signup";
		}
	}
	@RequestMapping("/signup")
	public String goRegister()
	{
		return "signup";
	}
	

}

