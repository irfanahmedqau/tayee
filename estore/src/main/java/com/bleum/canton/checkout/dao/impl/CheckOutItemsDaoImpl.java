package com.bleum.canton.checkout.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.dao.CheckOutItemsDao;
import com.bleum.canton.checkout.entity.CheckOutItemDetail;

@Repository("checkOutItemsDaoImpl")
public class CheckOutItemsDaoImpl implements CheckOutItemsDao{
	@Resource(name = "productSessionFactory")
	private SessionFactory productSessionFactory;
	@Transactional
	public void saveCheckOutItems(CheckOutItemDetail checkOutItemDetail) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public void updateCheckOutItems(CheckOutItemDetail checkOutItemDetail) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public CheckOutItemDetail findCheckOutItems(int checkOutItemDetailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
