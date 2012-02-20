/**
 * 
 */
package com.bleum.canton.myaccount.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bleum.canton.myaccount.command.CustomerForm;
import com.bleum.canton.myaccount.command.LoginForm;
import com.bleum.canton.myaccount.command.PwdSecuritySettingForm;
import com.bleum.canton.myaccount.command.RegisterForm;
import com.bleum.canton.myaccount.service.ICustomerService;
import com.bleum.canton.myaccount.util.MyAccConst;

/**
 * @author rudy.ding
 *
 */
@Controller
public class CustomerController {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	private static final String VIEW_REGISTER = "myaccount/register";
	private static final String VIEW_LOGIN = "myaccount/login";
	private static final String VIEW_MYACCHOME = "myaccount/home";
	private static final String MODEL_REGISTER_FORM = "registerForm";
	private static final String MODEL_LOGIN_FORM = "loginForm";
	private static final String MODEL_CUSTOMER_FORM = "customerForm";
	private static final String MODEL_RESULT_MESSAGE = "resultMessage";
	private static final String MSG_NULL = "";
	private static final String MSG_REGISTER_FAILURE = "sorry, register failed. please try again.";
	private static final String MSG_REGISTER_SUCCESS = "register successfully.";
	private static final String MSG_LOGIN_FAILURE = "sorry, login failed. please try again.";
	private static final String MSG_LOGIN_SUCCESS = "login successfully.";
	private static final String MSG_VALIFICATION_OK = "valid input";
	private static final String MSG_VALIFICATION_NG = "invalid input";
	
	
	@Resource(name="customerService")
	private ICustomerService customerService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		RegisterForm registerForm = new RegisterForm();
		ModelAndView mav = new ModelAndView();
		mav.addObject(MODEL_REGISTER_FORM, registerForm);
		mav.addObject(MODEL_RESULT_MESSAGE, MSG_NULL);
		mav.setViewName(VIEW_REGISTER);
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@Valid RegisterForm registerForm, BindingResult result, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// validation error
		if (result.hasErrors()) {
			mav.addObject(MODEL_REGISTER_FORM, registerForm);
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_REGISTER_FAILURE);
			mav.setViewName(VIEW_REGISTER);
            return mav;
		}
		
		// do register
		CustomerForm customerForm = customerService.register(registerForm);
		
		if(customerForm != null) {
			// success
			mav.setView(new RedirectView(VIEW_MYACCHOME));
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_REGISTER_SUCCESS);
			request.getSession().setAttribute(MyAccConst.CURRENT_LOGIN_NAME, customerForm.getLoginName());
			return mav;
		} else {
			mav.addObject(MODEL_REGISTER_FORM, registerForm);
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_REGISTER_FAILURE);
			mav.setViewName(VIEW_REGISTER);
            return mav;
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		LoginForm loginForm = new LoginForm();
		ModelAndView mav = new ModelAndView();
		mav.addObject(MODEL_LOGIN_FORM, loginForm);
		mav.addObject(MODEL_RESULT_MESSAGE, MSG_NULL);
		mav.setViewName(VIEW_LOGIN);
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@Valid LoginForm loginForm, BindingResult result, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// validation error
		if (result.hasErrors()) {
			mav.addObject(MODEL_LOGIN_FORM, loginForm);
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_LOGIN_FAILURE);
			mav.setViewName(VIEW_LOGIN);
            return mav;
		}
		
		// do login
		CustomerForm customerForm = customerService.login(loginForm);
		
		if(customerForm != null) {
			mav.setView(new RedirectView(VIEW_MYACCHOME));
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_LOGIN_SUCCESS);
			request.getSession().setAttribute(MyAccConst.CURRENT_LOGIN_NAME, customerForm.getLoginName());
			return mav;
		} else {
			mav.addObject(MODEL_LOGIN_FORM, loginForm);
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_LOGIN_FAILURE);
			mav.setViewName(VIEW_LOGIN);
            return mav;
		}

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//clear login information
		request.getSession().removeAttribute(MyAccConst.CURRENT_LOGIN_NAME);
		mav.setView(new RedirectView("index"));
		return mav;
	}
	
	@RequestMapping(value = "/ajaxCheckLoginName", method = RequestMethod.POST)
	public @ResponseBody String ajaxCheckLoginName(@RequestBody String loginName) {
		logger.debug("Checking LoginName: " + loginName);
		boolean isValid = customerService.isValidLoginName(loginName);
		if ( isValid) {
			return MSG_VALIFICATION_OK;
		}
		return MSG_VALIFICATION_NG;
	}
	
	@RequestMapping(value = "/ajaxCheckEmail", method = RequestMethod.POST)
	public @ResponseBody String ajaxCheckEmail(@RequestBody String email) {
		logger.debug("Checking Email: " + email);
		boolean isValid = customerService.isValidEmail(email);
		if ( isValid) {
			return MSG_VALIFICATION_OK;
		}
		return MSG_VALIFICATION_NG;
	}
	
	@RequestMapping(value = "/myaccount/home", method = RequestMethod.GET)
	public ModelAndView showCustomerHome(HttpServletRequest request) {
		logger.debug("show customer home...");
		ModelAndView mav = new ModelAndView();
		String loginName = (String)request.getSession().getAttribute(MyAccConst.CURRENT_LOGIN_NAME);
		if(loginName == null || loginName.trim().length() == 0){
			mav.addObject(MODEL_LOGIN_FORM, new LoginForm());
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_NULL);
			mav.setViewName(VIEW_LOGIN);
			return mav; 
		}
		CustomerForm customerForm = customerService.getCustomerFormByLoginName(loginName);
		
		if(customerForm != null) {
			// success
			mav.addObject(MODEL_CUSTOMER_FORM, customerForm);
			mav.setViewName(VIEW_MYACCHOME);
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_NULL);
			return mav;
		} else {
			// failure
			mav.addObject(MODEL_LOGIN_FORM, new LoginForm());
			mav.addObject(MODEL_RESULT_MESSAGE, MSG_NULL);
			mav.setViewName(VIEW_LOGIN);
			return mav;
		}
	}
	
	@RequestMapping(value = "/myaccount/update", method = RequestMethod.POST)
	public ModelAndView updateCustomer(CustomerForm customerForm) {
		logger.debug("show customer home:" + customerForm);
		customerForm = customerService.updateCustomer(customerForm);
		ModelAndView mav = new ModelAndView();
		mav.addObject(MODEL_CUSTOMER_FORM, customerForm);
		mav.setViewName(VIEW_MYACCHOME);
		return mav;
	}
	
	@RequestMapping(value = "/myaccount/refresh", method = RequestMethod.POST)
	public ModelAndView refreshCustomer(@ModelAttribute(MyAccConst.CURRENT_LOGIN_NAME) String loginName) {
		logger.debug("refresh customer information:" + loginName);
		CustomerForm customerForm = customerService.getCustomerFormByLoginName(loginName);
		ModelAndView mav = new ModelAndView();
		mav.addObject(MODEL_CUSTOMER_FORM, customerForm);
		mav.setViewName(VIEW_MYACCHOME);
		return mav;
	}
	
	/*
	@RequestMapping(value = "/lockCustomer", method = RequestMethod.POST)
	@ResponseBody
	public String lockCustomer(@RequestBody String customerId) {
		return "";
	} */
	
	@RequestMapping(value = "/activateCustomer", method = RequestMethod.POST)
	public ModelAndView activateCustomer(Long customerId) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/savePwdSecuritySettings", method = RequestMethod.POST)
	public ModelAndView savePwdSecuritySettings(@Valid PwdSecuritySettingForm pwdSecuritySettingForm) {
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
	
	@RequestMapping(value = "/verifySecurityAnswers", method = RequestMethod.POST)
	public ModelAndView verifySecurityAnswers() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
