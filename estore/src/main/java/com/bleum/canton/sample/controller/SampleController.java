package com.bleum.canton.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bleum.canton.sample.command.ProductForm;
import com.bleum.canton.sample.service.IProductManagementService;

@Controller
public class SampleController {

	private final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Resource(name = "productManagementService")
	private IProductManagementService productManagementService;
	
	private static final String PRODUCT_EDIT_PAGE = "sample/productEdit";
	
	private static final String PRODUCT_EDIT_FORM = "productEditForm";
	
	private static final String SAVE_PRODUCT_RESULT_ATTR = "saved";
	
	private static final String SAVE_PRODUCT_SUCCESS_MARK = "1";
	
	private static final String SAVE_PRODUCT_FAILURE_MARK = "0";
	
	@RequestMapping(value = "/productEditForm", method = RequestMethod.GET)
	public ModelAndView productEditPage(@ModelAttribute("productForm") ProductForm productForm, HttpServletRequest request) {
		logger.debug("[saved]: "+request.getParameter("saved"));
		ModelAndView mav = new ModelAndView(PRODUCT_EDIT_PAGE);
		mav.addObject(SAVE_PRODUCT_RESULT_ATTR, request.getParameter(SAVE_PRODUCT_RESULT_ATTR));
		return mav;
	}
	
	@RequestMapping(value = "/saveProductInfo", method = RequestMethod.POST)
	public ModelAndView saveProductInfo(@ModelAttribute("productForm") @Valid ProductForm productForm, BindingResult result) {
		if(result.hasErrors()) {
			logger.error("The form is invalid.");
			return new ModelAndView(PRODUCT_EDIT_PAGE);
		}
		logger.debug("[Product Name]: {}", productForm.getProductName());
		logger.debug("[Product SKU ID]: {}", productForm.getSkuId());
		logger.debug("[Available Storages]: {}", productForm.getStorages());
		productManagementService.saveProductAndStorages(productForm);
		ModelAndView mav = new ModelAndView(new RedirectView(PRODUCT_EDIT_FORM));
		mav.addObject(SAVE_PRODUCT_RESULT_ATTR, SAVE_PRODUCT_SUCCESS_MARK);
		return mav;
	}
	
}
