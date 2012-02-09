package com.bleum.canton.sample.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.sample.dao.IProductDao;
import com.bleum.canton.sample.entity.Product;

@Repository("productDao")
public class ProductDao implements IProductDao {
	
	@Resource(name = "productSessionFactory")
	private SessionFactory sessionFactory;

	public void saveProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}

}
