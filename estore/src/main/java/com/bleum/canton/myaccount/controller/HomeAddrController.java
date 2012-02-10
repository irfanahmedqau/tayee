/**
 * 
 */
package com.bleum.canton.myaccount.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.myaccount.command.HomeAddrForm;

/**
 * @author rudy.ding
 *
 */
@Controller
public class HomeAddrController {
	
	private final Logger logger = LoggerFactory.getLogger(HomeAddrController.class);
	
	@RequestMapping(value="/addHomeAddress",method=RequestMethod.POST)
	public ModelAndView addHomeAddr(@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
		

	
	@RequestMapping(value="/modifyHomeAddress",method=RequestMethod.POST)
	public ModelAndView modifyHomeAddr(@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/deleteHomeAddress",method=RequestMethod.POST)
	public ModelAndView deleteHomeAddr(@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/getHomeAddress",method=RequestMethod.POST)
	public ModelAndView getAllHomeAddr(@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/getDefaultHomeAddr",method=RequestMethod.POST)
	public ModelAndView getDefaultHomeAddr(@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	
	@RequestMapping(value="/getRecentUseHomeAddr",method=RequestMethod.POST)
	public ModelAndView getRecentUseHomeAddr(@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	
	
}
