package com.bleum.canton.checkout.dao;

import com.bleum.canton.checkout.entity.CheckOutItemDetail;

public interface CheckOutItemsDao {
	void saveCheckOutItems(CheckOutItemDetail checkOutItemDetail);
	void updateCheckOutItems(CheckOutItemDetail checkOutItemDetail);
	CheckOutItemDetail findCheckOutItems(int checkOutItemDetailId);
}
