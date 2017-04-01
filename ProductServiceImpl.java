package com.dresses.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dresses.dao.ProductDaoImpl;
import com.dresses.model.Product;

@Service

public class ProductServiceImpl implements ProductService {


			@Autowired
			private ProductDaoImpl ProductDao;

			public void setProductDao(ProductDaoImpl ProductDao) {
				this.ProductDao = ProductDao;
			}

			
			@Override
			@Transactional
			public void updateProduct(Product p) {
				this.ProductDao.updateProduct(p);
			}

			@Override
			@Transactional
			public List<Product> listProducts() {
				return this.ProductDao.listProducts();
			}

			@Override
			@Transactional
			public Product getProductById(int id) {
				return this.ProductDao.getProductById(id);
			}

			@Override
			@Transactional
			public void removeProduct(int id) {
				this.ProductDao.removeProduct(id);
			}


			@Override
			public void add(Product p) {
				// TODO Auto-generated method stub
				
			}


	}


