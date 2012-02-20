package com.bleum.canton.checkout.dao.impl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.dao.ICheckOutDao;
import com.bleum.canton.checkout.entity.CheckOut;
import com.bleum.canton.checkout.entity.Invoice;
import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.checkout.entity.ShippingMethod;
import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;

//@Repository("checkOutDaoImpl")
public class CheckOutDaoImpl extends BaseDaoHibernateImpl<CheckOut> implements ICheckOutDao{
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
