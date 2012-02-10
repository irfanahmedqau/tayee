package com.bleum.canton.itempage.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.itempage.dao.IProductDao;
import com.bleum.canton.itempage.entity.Product;

@Repository("productDaoImp")
public class ProductDaoImpl implements IProductDao {
	
	@Resource(name="productSessionFactory")
	private SessionFactory sessionFactory;
	
	public Product findById(String productID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, productID);
		
		return product;
	}

}
