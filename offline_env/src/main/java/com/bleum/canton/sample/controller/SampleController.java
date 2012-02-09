package com.bleum.canton.sample.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bleum.canton.sample.command.ProductForm;
import com.bleum.canton.sample.service.ICategoryManagementService;
import com.bleum.canton.sample.service.IProductManagementService;

@Controller
public class SampleController {

	private final Logger logger = Logger.getLogger(SampleController.class);
	
	@Resource(name = "productManagementService")
	private IProductManagementService productManagementService;
	
	@Resource(name= "categoryManagementService")
	private ICategoryManagementService categoryManagementService;
	
	private static final String PRODUCT_EDIT_PAGE = "sample/productEdit";
	
	private static final String PRODUCT_EDIT_FORM = "productEditForm";
	
	private static final String SAVE_PRODUCT_RESULT_ATTR = "saved";
	
	private static final String SAVE_PRODUCT_SUCCESS_MARK = "1";
	
	private static final String SAVE_PRODUCT_FAILURE_MARK = "0";
	
	private static final String CATEGORY_HOME_PAGE = "category/home";
	
	@RequestMapping(value = "/productEditForm", method = RequestMethod.GET)
	public ModelAndView productEditPage(HttpServletRequest request) {
		logger.debug("IP[" + request.getRemoteAddr() + "] visits the Product Edit page.");
		logger.debug("[saved]: "+request.getParameter("saved"));
		ModelAndView mav = new ModelAndView(PRODUCT_EDIT_PAGE);
		mav.addObject(SAVE_PRODUCT_RESULT_ATTR, request.getParameter(SAVE_PRODUCT_RESULT_ATTR));
		return mav;
	}
	
	@RequestMapping(value = "/saveProductInfo", method = RequestMethod.POST)
	public ModelAndView saveProductInfo(@ModelAttribute ProductForm product) {
		logger.debug("[Product Name]: " + product.getProductName());
		logger.debug("[Product SKU ID]: " + product.getSkuId());
		logger.debug("[Available Storages]: " + product.getStorages());
		productManagementService.saveProductAndStorages(product);
		ModelAndView mav = new ModelAndView(new RedirectView(PRODUCT_EDIT_FORM));
		mav.addObject(SAVE_PRODUCT_RESULT_ATTR, SAVE_PRODUCT_SUCCESS_MARK);
		return mav;
	}
	 
	@RequestMapping(value= "/home", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request){
		logger.debug("load homepage...");
		ModelAndView mav = new ModelAndView(CATEGORY_HOME_PAGE);
		return mav;
	}
	
	@RequestMapping(value= "/loadingCategory", method = RequestMethod.GET)
	public ModelAndView loadingCategory(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "node") String node){
		logger.debug("loadingCategory...");
		String parentId = "1001";
		logger.debug("[parentId]: "+ parentId);
		logger.debug("[node]: " + node);
		
		ModelAndView mav = new ModelAndView(CATEGORY_HOME_PAGE);
		response.setContentType("charset=UTF-8");
		String json = categoryManagementService.getCategoryJSON(parentId);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch b
			logger.error("error happens when loading category");
			e.printStackTrace();
		}
		return null;
	}
	
}
