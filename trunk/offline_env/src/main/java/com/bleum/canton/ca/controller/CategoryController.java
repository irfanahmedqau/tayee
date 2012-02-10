package com.bleum.canton.ca.controller;

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

import com.bleum.canton.ca.service.ICategoryManagementService;


@Controller
public class CategoryController {

	private final Logger logger = Logger.getLogger(CategoryController.class);
	
	@Resource(name= "categoryManagementService")
	private ICategoryManagementService categoryManagementService;
	
	private static final String CATEGORY_HOME_PAGE = "category/home";
	
		 
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
