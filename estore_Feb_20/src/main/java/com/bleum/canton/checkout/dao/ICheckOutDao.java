package com.bleum.canton.checkout.dao;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.entity.CheckOut;
import com.bleum.canton.checkout.entity.CheckOutItemDetail;
import com.bleum.canton.checkout.entity.Invoice;
import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.checkout.entity.ShippingMethod;
import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
@Transactional
@DAO(name="checkOutDaoImpl")
public interface ICheckOutDao extends BaseDao<CheckOut>{
	void saveCheckOut(CheckOut checkOut);
	void updateCheckOut(CheckOut checkOut);
	CheckOut findCheckOut(int checkOutId);


}
