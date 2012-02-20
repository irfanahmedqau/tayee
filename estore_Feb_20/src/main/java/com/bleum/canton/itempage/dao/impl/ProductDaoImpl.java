package com.bleum.canton.itempage.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.itempage.dao.IProductDao;
import com.bleum.canton.itempage.entity.Product;

//@Repository("productDaoImpl")
@Component("productDaoImpl")
public class ProductDaoImpl{
	
	@Resource(name="catalogSessionFactory")
	SessionFactory sessionFactory;
	
	@Autowired
	private ProductRCDaoImpl prcDao;
	@Autowired
	private ProductVarientDaoImpl pvDao;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}	
	
	@Transactional
	public Product findById(int productID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM Product as p WHERE p.id=?");
		query.setInteger(0, productID);
		
		return (Product)query.list().get(0);
	}
	
	@Transactional
	public List<Product> findProductByCategoryID(String categoryID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM Product as p WHERE p.p_category=?");
		query.setString(0, categoryID);

		return query.list();
	}

}
