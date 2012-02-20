package com.bleum.canton.checkout.dao.impl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.dao.ICheckOutItemsDao;
import com.bleum.canton.checkout.entity.CheckOutItemDetail;
import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;

//@Repository("checkOutItemsDaoImpl")
public class CheckOutItemsDaoImpl extends BaseDaoHibernateImpl<CheckOutItemDetail> implements ICheckOutItemsDao{
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
