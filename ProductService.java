package com.dresses.service;
import java.util.List;

import com.dresses.model.Product;

public interface ProductService {

	public void add(Product p);
	
	public void updateProduct(Product p);
	public List<Product> listProducts();
	public Product getProductById(int id);
	void removeProduct(int id);
	
}
