package com.dresses.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dresses.model.Customer;
@Repository
public class customerDaoImpl implements customerDao {
	@Autowired
	SessionFactory sf;

	@Override
	public boolean addCustomer(Customer c) {
		Session s=sf.openSession();
		s.save(c);
		return true;
	}

	@Override
	public boolean delCustomer(int id) {
		Session s=sf.openSession();
		Customer c=s.get(Customer.class,id);
		s.delete(c);
		return true;
	}

	@Override
	public boolean updCustomer(Customer c) {
		Session s=sf.openSession();
		s.update(c);
		return true;
	}

	@Override
	public Customer getCustomerByName(String name) {
		Session s=sf.openSession();
		Query q = s.createQuery("from Customer where cname =" +name);
		return(Customer) q.uniqueResult();
	}

	@Override
	public List<Customer> getAllCustomer() {

		Session s = sf.openSession();
		List<Customer> l = s.createQuery("from Customer").list();
		return l;
	}

}
