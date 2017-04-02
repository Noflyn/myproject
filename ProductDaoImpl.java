package com.dresses.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dresses.model.Product;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public ProductDaoImpl(){
		
	}
	public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
	public void addProduct(Product product){
		  Session session=sessionFactory.getCurrentSession();
		  session.save(product);
	}

	public void updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
	}
	

	public List<Product> listProduct() {
		
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Product").list();
	}
	public void deleteProduct(int id) {
	//sessionFactory.getCurrentSession().delete(id);;
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE id = "+id).executeUpdate();
		
		
	}
	public Product getbyid(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
		
	}
	    }
	
