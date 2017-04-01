package com.dresses.dao;
import java.util.List;

import com.dresses.model.Product;

	public interface ProductDao {
		
		
		public void updateProduct(Product p);
		public List<Product> listProducts();
		public Product getProductById(int id);
		public void removeProduct(int id);
		public void add(Product p);
	}



