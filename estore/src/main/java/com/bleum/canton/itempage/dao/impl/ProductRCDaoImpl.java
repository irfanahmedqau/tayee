package com.bleum.canton.itempage.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.itempage.dao.IProductRCDao;
import com.bleum.canton.itempage.entity.ProductRichContent;

@Repository("productRCDaoImp")
public class ProductRCDaoImpl implements IProductRCDao {
	
	@Resource(name="productSessionFactory")
	private SessionFactory sessionFactory;
	
	public ProductRichContent getPRCByProductID(String productID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ProductRichContent prc = (ProductRichContent) session.get(ProductRichContent.class, productID);
		
		return prc;
	}

	public ProductRichContent getPRCByID(String prcID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ProductRichContent prc = (ProductRichContent) session.get(ProductRichContent.class, prcID);
		
		return null;
	}

}
