package com.bleum.canton.itempage.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.itempage.dao.IProductRCDao;
import com.bleum.canton.itempage.entity.ProductRichContent;

//@Repository("productRCDaoImpl")
@Component("productRCDaoImpl")
public class ProductRCDaoImpl{
	
	@Resource(name="catalogSessionFactory")
	SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}	
	
	@Transactional
	public ProductRichContent findPRCByID(int prcID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM ProductRichContent as prc WHERE prc.id=?");
		query.setInteger(0, prcID);

		return (ProductRichContent) query.list().get(0);
	}
	
	@Transactional
	public List<ProductRichContent> findPRCByProductID(int productID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM ProductRichContent as prc WHERE prc.rc_product=?");
		query.setInteger(0, productID);

		return query.list();
	}

}
