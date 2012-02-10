package com.bleum.canton.sample.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.sample.dao.IProductStorageDao;
import com.bleum.canton.sample.entity.ProductStorage;

@Repository("productStorageDao")
public class ProductStorageDao implements IProductStorageDao {

	@Resource(name = "storageSessionFactory")
	private SessionFactory sessionFactory;
	
	public void saveProductStorage(ProductStorage productStorage) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productStorage);
	}

}
