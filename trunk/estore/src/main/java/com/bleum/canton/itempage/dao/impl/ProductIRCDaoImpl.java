package com.bleum.canton.itempage.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.itempage.dao.IProductIRCDao;
import com.bleum.canton.itempage.entity.ProductIRC;

@Repository("productIRCDaoImp")
public class ProductIRCDaoImpl implements IProductIRCDao {
	
	@Resource(name="productSessionFactory")
	private SessionFactory sessionFactory;
	
	public ProductIRC getPIRCByProductID(String productID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ProductIRC pirc = (ProductIRC) session.get(ProductIRC.class, productID);
		
		return pirc;
	}

	public ProductIRC getPIRCByID(String productIRCID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ProductIRC pirc = (ProductIRC) session.get(ProductIRC.class, productIRCID);
		
		return null;
	}

}
