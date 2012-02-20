package com.bleum.canton.checkout.dao;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.entity.CheckOutItemDetail;
import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
@Transactional
@DAO(name="checkOutItemsODaoImpl")
public interface ICheckOutItemsDao extends BaseDao<CheckOutItemDetail>{
	void saveCheckOutItems(CheckOutItemDetail checkOutItemDetail);
	void updateCheckOutItems(CheckOutItemDetail checkOutItemDetail);
	CheckOutItemDetail findCheckOutItems(int checkOutItemDetailId);
}
