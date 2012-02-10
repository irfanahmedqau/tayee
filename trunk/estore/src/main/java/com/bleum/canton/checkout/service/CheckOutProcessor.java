package com.bleum.canton.checkout.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.dao.CheckOutDao;
import com.bleum.canton.checkout.dao.CheckOutItemsDao;
import com.bleum.canton.checkout.entity.Invoice;


@Component("checkOutProcessor")
public class CheckOutProcessor {
	@Autowired
	private CheckOutDao checkOutDaoImpl;
	@Autowired
	private CheckOutItemsDao checkOutItemsODaoImpl;
	@Transactional
	public Map initialCheckOut(Map map){
		return null;
	}
	@Transactional
	public Map postToOms(Map map){
		return null;
	}
	@Transactional
	public void saveAccountInfo(){
		return;
	}
	@Transactional
	public void savePaymentAndShippingMethod(Map map){
		return;
	}
	@Transactional
	public void saveInvoiceInfo(Invoice invoice){
		return;
	}
}
