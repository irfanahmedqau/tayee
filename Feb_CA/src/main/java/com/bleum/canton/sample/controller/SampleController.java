package com.bleum.canton.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	
	private final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	private static final String INDEX_PAGE = "sample/index";
	
	private static final String SECURE_PAGE = "sample/secure";

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexView(HttpServletRequest request) {
		if(request instanceof HttpServletRequestWrapper) {
			logger.debug("The request has been wrapt.");
		}
		logger.debug("request[servlet path]: {}", request.getServletPath());
		logger.debug("request[URI]: {}",request.getRequestURI());
		logger.debug("request[URL]: {}",request.getRequestURL());
		logger.debug("request[Path Info]: {}",request.getPathInfo());
		logger.debug("request[Path Translated]: {}",request.getPathTranslated());
		return new ModelAndView(INDEX_PAGE);
	}
	
	@RequestMapping(value = "/secure/account", method = RequestMethod.GET)
	public ModelAndView secureView() {
		return new ModelAndView(SECURE_PAGE);
	}
	
}
