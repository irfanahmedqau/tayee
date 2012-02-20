package com.bleum.canton.checkout.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.command.TriggerForm;
import com.bleum.canton.checkout.dao.ICheckOutDao;
import com.bleum.canton.checkout.dao.ICheckOutItemsDao;
import com.bleum.canton.checkout.dao.IInvoiceDao;
import com.bleum.canton.checkout.dao.IPaymentMethodDao;
import com.bleum.canton.checkout.dao.IShippingMethodDao;
import com.bleum.canton.checkout.entity.CheckOut;
import com.bleum.canton.checkout.entity.CheckOutItemDetail;
import com.bleum.canton.checkout.entity.Invoice;
import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.checkout.entity.ShippingMethod;
import com.bleum.canton.checkout.service.ICheckOutService;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.itempage.service.IItempageService;
import com.bleum.canton.myaccount.entity.HomeAddr;
import com.bleum.canton.myaccount.service.IHomeAddrService;

@Transactional
@Component("checkOutServiceImpl")
public class CheckOutServiceImpl implements ICheckOutService {
	private static final Logger logger = LoggerFactory.getLogger(CheckOutServiceImpl.class);
	@Autowired
	private ICheckOutDao checkOutDaoImpl;
	@Autowired
	private ICheckOutItemsDao checkOutItemsODaoImpl;
	@Autowired
	private IInvoiceDao invoiceDaoImpl;
	@Autowired
	private IPaymentMethodDao paymentMethodDaoImpl;
	@Autowired
	private IShippingMethodDao shippingMethodDaoImpl;
	@Autowired
	private IItempageService itempageServiceImpl;
	@Autowired
	private IHomeAddrService homeAddrServiceImpl;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, ?> initialCheckOut(TriggerForm form) {
		CheckOut checkout = new CheckOut();
		checkout.setCustomerId(Integer.valueOf(form.getCustomerID()));
		checkout.setItemCollection(consultDetails(form.getAllItems()));
		List<Item> items = new ArrayList<Item>()/*itempageServiceImpl.getRequiredItems(form.getAllItems())*/;
		checkout.setAmount(consultTheAmount(items));
		CheckOut checkOut_t = checkOutDaoImpl.create(checkout);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("checkOutID", checkOut_t.getId());
		result.put("productItemList", items);
		// result.put("defaultAddr",
		// homeAddrServiceImpl.getDefaultHomeAddr(Long.valueOf(form.getCustomerID())));
		return result;
	}

	private List<CheckOutItemDetail> consultDetails(int[] items) {
		List<CheckOutItemDetail> result = new ArrayList<CheckOutItemDetail>();
		for (int item : items) {
			CheckOutItemDetail detail = new CheckOutItemDetail();
			detail.setProductItemId(String.valueOf(item));
			result.add(detail);
		}
		return result;
	}

	private double consultTheAmount(List<Item> items) {
		debug("consult the amount without promotion");
		if (true) {
			return 63.56;
		}
		BigDecimal result = new BigDecimal(0);
		for (Item item : items) {
			result.add(BigDecimal.valueOf(item.getPrice()));
		}
		return result.doubleValue();
	}

	public Map postToOms(Map map) {
		return null;
	}

	public Integer saveAccountInfo(int checkOutId) {
		CheckOut checkout = checkOutDaoImpl.findCheckOut(checkOutId);
		checkout.setAddressCartID(656);
		checkOutDaoImpl.update(checkout);
		return checkout.getId();
	}

	public Integer saveInvoiceInfo(Invoice invoice, int checkOutId) {
		Invoice invoice_c = invoiceDaoImpl.create(invoice);
		CheckOut checkout = checkOutDaoImpl.findCheckOut(checkOutId);
		checkout.setInvoice(invoice_c);
		checkOutDaoImpl.update(checkout);
		return invoice_c.getId();
	}

	public Integer savePaymentMethod(PaymentMethod paymentMethod, int checkOutId) {
		PaymentMethod paymentMethod_t = paymentMethodDaoImpl.create(paymentMethod);
		CheckOut checkout = checkOutDaoImpl.findCheckOut(checkOutId);
		checkout.setPaymentMethod(paymentMethod_t);
		checkOutDaoImpl.update(checkout);
		return paymentMethod_t.getId();

	}

	public Integer saveShippingMethod(ShippingMethod shippingMethod, int checkOutId) {
		ShippingMethod shippingMethod_t = shippingMethodDaoImpl.create(shippingMethod);
		CheckOut checkout = checkOutDaoImpl.findCheckOut(checkOutId);
		checkout.setShippingMethod(shippingMethod_t);
		checkOutDaoImpl.update(checkout);
		return shippingMethod_t.getId();

	}

	private void debug(String message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

	public boolean isCheckOutInfoCompleted(int checkOutId) {
		CheckOut checkout = checkOutDaoImpl.findCheckOut(checkOutId);
		if (checkout.getInvoice() == null || checkout.getPaymentMethod() == null
				|| checkout.getShippingMethod() == null) {
			return false;
		}
		return true;
	}
}
