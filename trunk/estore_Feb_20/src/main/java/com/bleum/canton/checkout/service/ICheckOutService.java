package com.bleum.canton.checkout.service;

import java.util.Map;

import com.bleum.canton.checkout.command.TriggerForm;
import com.bleum.canton.checkout.entity.Invoice;
import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.checkout.entity.ShippingMethod;

public interface ICheckOutService {
	Map<String, ?> initialCheckOut(TriggerForm form);

	Map postToOms(Map map);

	Integer saveAccountInfo(int checkOutId);

	Integer savePaymentMethod(PaymentMethod paymentMethod ,int checkOutId);

	Integer saveShippingMethod(ShippingMethod shippingMethod, int checkOutId);

	Integer saveInvoiceInfo(Invoice invoice, int checkOutId);
	
	boolean isCheckOutInfoCompleted(int checkOutId);
}
