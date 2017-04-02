package com.dresses.dao;

import java.util.List;

import com.dresses.model.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> listProduct();
	public void deleteProduct(int id);
	public Product getbyid(int id);
}


