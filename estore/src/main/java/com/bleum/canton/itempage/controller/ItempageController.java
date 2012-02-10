package com.bleum.canton.itempage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.itempage.service.IItempageService;

@Controller
@Transactional
public class ItempageController {
	
	private final Logger logger = LoggerFactory.getLogger(ItempageController.class);
	
	@RequestMapping(value="/viewProduct", method=RequestMethod.GET)
	public ModelAndView viewProduct(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/changeItem", method=RequestMethod.GET)
	public ModelAndView changeItem(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
