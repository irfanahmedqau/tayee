package com.bleum.canton.checkout.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.checkout.service.CheckOutProcessor;

@Controller
@Transactional
public class CheckOutController {
	@Autowired
	private CheckOutProcessor checkOutProcessor;
	
	private static final String checkOutPage="";
	
	@RequestMapping(value = "/checkOutTrigger", method = RequestMethod.GET)
	public ModelAndView checkOutTrigger(ModelMap model, HttpServletRequest request, 
			HttpServletResponse response){
		return new ModelAndView("checkout/checkout");
	}
	@RequestMapping(value = "/toOms", method = RequestMethod.GET)
	public ModelAndView toOms(ModelMap model, HttpServletRequest request, 
			HttpServletResponse response){
		return null;
	}
	@RequestMapping(value = "/saveAccountInfo", method = RequestMethod.GET)
	public ModelAndView saveAccountInfo(ModelMap model, HttpServletRequest request, 
			HttpServletResponse response){
		return null;
	}
	@RequestMapping(value = "/savePaymentAndShippingMethod", method = RequestMethod.GET)
	public ModelAndView savePaymentAndShippingMethod(ModelMap model, HttpServletRequest request, 
			HttpServletResponse response){
		return null;
	}
	@RequestMapping(value = "/saveInvoiceInfo", method = RequestMethod.GET)
	public ModelAndView saveInvoiceInfo(ModelMap model, HttpServletRequest request, 
			HttpServletResponse response){
		return null;
	}
	@RequestMapping(value = "/fetchCustomerID", method = RequestMethod.GET)
	private int fetchCustomerID(ModelMap model, HttpServletRequest request, 
			HttpServletResponse response){
		return 0;
	}
	@RequestMapping(value = "/fetchProductItemIDs", method = RequestMethod.GET)
	private List fetchProductItemIDs(ModelMap model, HttpServletRequest request, 
			HttpServletResponse response){
		return null;
	}
}
