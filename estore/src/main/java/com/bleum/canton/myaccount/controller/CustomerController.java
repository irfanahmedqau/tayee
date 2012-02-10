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

import com.bleum.canton.myaccount.command.LoginForm;
import com.bleum.canton.myaccount.command.RegisterForm;

/**
 * @author rudy.ding
 *
 */
@Controller
public class CustomerController {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("RegisterForm") RegisterForm registerForm) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("LoginForm") LoginForm loginForm) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	//ajax request
	@RequestMapping(value = "/validateLoginName", method = RequestMethod.POST)
	public ModelAndView validateLoginName() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	//ajax request
	@RequestMapping(value = "/lockCustomer", method = RequestMethod.POST)
	public ModelAndView lockCustomer() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/activateCustomer", method = RequestMethod.POST)
	public ModelAndView activateCustomer() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/savePwdSecuritySettings", method = RequestMethod.POST)
	public ModelAndView savePwdSecuritySettings() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/emailChangePwd", method = RequestMethod.POST)
	public ModelAndView emailChangePwd() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/snsChangePwd", method = RequestMethod.POST)
	public ModelAndView snsChangePwd() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/changePwd", method = RequestMethod.POST)
	public ModelAndView changePwd() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/getSecurityQuestions", method = RequestMethod.GET)
	public ModelAndView getSecurityQuestions() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/verifySecurityAnswer", method = RequestMethod.POST)
	public ModelAndView verifySecurityAnswer() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
