package com.dresses.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.dresses.model.Product;


public class ProductDaoImpl implements ProductDao {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void add(Product p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Autowired
	public List<Product> list() {
		Session session = this.sessionFactory.openSession();
		List<Product> ProductList = session.createQuery("from Product").list();
		session.close();
		return ProductList;
	}

	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeProduct(int id) {
		// TODO Auto-generated method stub
		
	}

}

