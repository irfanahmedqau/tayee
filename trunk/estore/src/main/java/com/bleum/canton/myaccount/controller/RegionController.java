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

import com.bleum.canton.myaccount.command.RegionForm;

/**
 * @author rudy.ding
 *
 */
@Controller
public class RegionController {
	
	private final Logger logger = LoggerFactory.getLogger(RegionController.class);

	@RequestMapping(value="/getCountries",method=RequestMethod.POST)
	public ModelAndView getCountries(@ModelAttribute("RegionForm") RegionForm regionForm ){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/getProvinces",method=RequestMethod.POST)
	public ModelAndView getProvinces(@ModelAttribute("RegionForm") RegionForm regionForm ){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/getCities",method=RequestMethod.POST)
	public ModelAndView getCities(@ModelAttribute("RegionForm") RegionForm regionForm ){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/getDistricts",method=RequestMethod.POST)
	public ModelAndView getDistricts(@ModelAttribute("RegionForm") RegionForm regionForm ){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
