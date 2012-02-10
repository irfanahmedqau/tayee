package com.bleum.canton.shoppingcart.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.shoppingcart.service.IShoppingCartService;

@Controller
@RequestMapping("/shoppingcart/*")
public class ShoppingCartController {
	
	@Resource(name = "shoppingCartService")
	private IShoppingCartService shoppingCartService;
	
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public ModelAndView deleteItem(){
	
		return null;
	}
	
	@RequestMapping(value = "/display", method=RequestMethod.GET)
	public ModelAndView displayAll(){
		
		return null;
	}
	

}
