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
import com.bleum.canton.itempage.dao.IProductVarientDao;
import com.bleum.canton.itempage.entity.ProductVarient;

//@Repository("productVarientDaoImpl")
@Component("productVarientDaoImpl")
public class ProductVarientDaoImpl{
	
	@Resource(name="catalogSessionFactory")
	SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}	
	
	@Transactional
	public ProductVarient findPVByID(int productVarientID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM ProductVarient as pv WHERE pv.id=?");
		query.setInteger(0, productVarientID);

		return (ProductVarient)query.list().get(0);
	}
	
	@Transactional
	public List<ProductVarient> findPVByProductID(int productID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM ProductVarient as pv WHERE pv.v_product=?");
		query.setInteger(0, productID);

		return query.list();
	}

}
