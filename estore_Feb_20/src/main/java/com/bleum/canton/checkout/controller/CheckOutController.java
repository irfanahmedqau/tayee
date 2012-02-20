package com.bleum.canton.checkout.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.checkout.command.CheckOutForm;
import com.bleum.canton.checkout.command.TriggerForm;
import com.bleum.canton.checkout.entity.Invoice;
import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.checkout.entity.ShippingMethod;
import com.bleum.canton.checkout.service.ICheckOutService;

@Controller
public class CheckOutController {
	@Autowired
	private ICheckOutService checkOutServiceImpl;

	private final Logger logger = LoggerFactory.getLogger(CheckOutController.class);

	@RequestMapping(value = "/checkOutTrigger", method = RequestMethod.POST)
	public ModelAndView checkOutTrigger(@ModelAttribute("triggerForm") TriggerForm triggerForm) {
		Map<String, ?> returnMap = checkOutServiceImpl.initialCheckOut(triggerForm);
		ModelAndView result = new ModelAndView("checkout/checkout");
		result.addAllObjects(returnMap);
		result.addObject("customerID", triggerForm.getCustomerID());
		return result;
	}

	@RequestMapping(value = "/toOms", method = RequestMethod.POST)
	public ModelAndView toOms(@ModelAttribute("checkOutForm") CheckOutForm checkOutForm) {
		System.out.println(checkOutForm.getArea());
		return new ModelAndView("checkout/thankuPage");
	}

	@RequestMapping(value = "/saveAccountInfo", method = RequestMethod.POST)
	public @ResponseBody
	AddressResponse saveAccountInfo(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("now will save the account info ");
		checkOutServiceImpl.saveAccountInfo(Integer.valueOf(request.getParameter("checkOutID")));
		AddressResponse result = new AddressResponse();
		result.setStatus("success");
		result.setAddressCard("justTest");
		logger.debug("save the account info finished ");
		return result;
	}

	@RequestMapping(value = "/saveShippingMethod", method = RequestMethod.POST)
	public @ResponseBody
	ShippingMethodResponse saveShippingMethod(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		ShippingMethod shippingMethod = buildShippingMethod(request);
		Integer shippingMethodId = checkOutServiceImpl.saveShippingMethod(shippingMethod,
				Integer.valueOf(request.getParameter("checkOutID")));
		ShippingMethodResponse res = new ShippingMethodResponse();
		res.setStatus("success");
		res.setShippingMethodId(shippingMethodId.toString());
		return res;
	}

	@RequestMapping(value = "/savePaymentMethod", method = RequestMethod.POST)
	public @ResponseBody
	PaymentMethodResponse savePaymentMethod(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setName(request.getParameter("payType"));
		Integer paymentMethodId = checkOutServiceImpl.savePaymentMethod(paymentMethod,
				Integer.valueOf(request.getParameter("checkOutID")));
		PaymentMethodResponse res = new PaymentMethodResponse();
		res.setStatus("success");
		res.setPaymentMethodId(paymentMethodId.toString());
		response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
		return res;
	}

	@RequestMapping(value = "/saveInvoiceInfo", method = RequestMethod.POST)
	public @ResponseBody
	InvoiceResponse saveInvoiceInfo(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Invoice invoice = new Invoice();
		invoice.setName(request.getParameter("invoiceName"));
		invoice.setType(request.getParameter("invoiceType"));
		invoice.setDescription(request.getParameter("invoiceContent"));
		Integer invoiceId = checkOutServiceImpl.saveInvoiceInfo(invoice,
				Integer.valueOf(request.getParameter("checkOutID")));
		InvoiceResponse res = new InvoiceResponse();
		res.setStatus("success");
		res.setInvoiceId(invoiceId.toString());
		return res;
	}

	@RequestMapping(value = "/isInfoCompleted", method = RequestMethod.POST)
	public @ResponseBody
	ConfirmResponse isInfoCompleted(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		if (checkOutServiceImpl.isCheckOutInfoCompleted(Integer.valueOf(request.getParameter("checkOutID")))) {
			ConfirmResponse res = new ConfirmResponse();
			res.setStatus("success");
			return res;
		}
		ConfirmResponse res = new ConfirmResponse();
		res.setStatus("false");
		res.setMessage("信息确认不完全，请完善！");
		return res;
	}

	@RequestMapping(value = "/fetchCustomerID", method = RequestMethod.GET)
	private int fetchCustomerID(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return 0;
	}

	@RequestMapping(value = "/fetchProductItemIDs", method = RequestMethod.GET)
	private List fetchProductItemIDs(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	private ShippingMethod buildShippingMethod(HttpServletRequest request) {
		ShippingMethod shippingMethod = new ShippingMethod();
		shippingMethod.setShippingExpectDate(request.getParameter("shippingExpectDate"));
		shippingMethod.setShippingDetailTime(request.getParameter("shippingDetailTime"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date shippingExactDate = sdf.parse(request.getParameter("shippingExactDate"));
			shippingMethod.setShippingExactDate(shippingExactDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return shippingMethod;
	}
}

class AddressResponse {
	private String addressCard;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddressCard() {
		return addressCard;
	}

	public void setAddressCard(String addressCard) {
		this.addressCard = addressCard;
	}

}

class PaymentMethodResponse {
	private String paymentMethodId;
	private String status;

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

class InvoiceResponse {
	private String invoiceId;
	private String status;

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

class ShippingMethodResponse {
	private String shippingMethodId;
	private String status;

	public String getShippingMethodId() {
		return shippingMethodId;
	}

	public void setShippingMethodId(String shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

class ConfirmResponse {
	private String message;
	private String status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}