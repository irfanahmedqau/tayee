package com.bleum.canton.search.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.search.service.IIndexService;

@Controller
@RequestMapping("/admin/search/*")
public class IndexController {
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Resource(name = "indexService")
	private IIndexService indexService;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("admin/search/index");
	}

	@RequestMapping("/create")
	public ModelAndView create() {
		try {
			indexService.createIndex();
		} catch (Exception e) {
			logger.warn("Failed to create index", e);
		}
		logger.debug("Create index");
		return new ModelAndView("admin/search/index");
	}

	@RequestMapping("/clear")
	public ModelAndView clear() {
		indexService.clear();
		logger.debug("Clear index");
		return new ModelAndView("admin/search/index");
	}
}
