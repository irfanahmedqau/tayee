package com.bleum.canton.checkout.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.dao.CheckOutDao;
import com.bleum.canton.checkout.entity.CheckOut;

@Repository("checkOutDaoImpl")
public class CheckOutDaoImpl implements CheckOutDao{
	@Resource(name = "productSessionFactory")
	private SessionFactory productSessionFactory;
	@Transactional
	public void saveCheckOut(CheckOut checkOut) {
	}
	@Transactional
	public void updateCheckOut(CheckOut checkOut) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public CheckOut findCheckOut(int checkOutId) {
		// TODO Auto-generated method stub
		return null;
	}

}
