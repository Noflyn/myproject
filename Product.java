package com.dresses.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Product {
	@GeneratedValue(strategy=GenerationType. IDENTITY)
	private int cid;
	private String cname;
	private String email;
	private String password;
	public int getCid() {
		return cid;
	}
}