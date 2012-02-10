package com.bleum.canton.checkout.dao;

import com.bleum.canton.checkout.entity.CheckOut;

public interface CheckOutDao {
	void saveCheckOut(CheckOut checkOut);
	void updateCheckOut(CheckOut checkOut);
	CheckOut findCheckOut(int checkOutId);
}
