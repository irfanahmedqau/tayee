package com.bleum.canton.search.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bleum.canton.search.bean.SearchResult;
import com.bleum.canton.search.command.SearchForm;
import com.bleum.canton.search.service.ISearchService;

@Controller
public class SearchController {
	private final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Resource(name = "searchService")
	private ISearchService searchService;

	@RequestMapping("/search")
	public ModelAndView search(SearchForm form) {
		ModelAndView view = new ModelAndView("search/searchResult");
		SearchResult result = null;
		try {
			result = searchService.query(form);
		} catch (Exception e) {
			logger.warn("Getting search result", e);
			return new ModelAndView(new RedirectView("search/errorPage"));
		}
		view.addObject("searchResult", result);
		return view;
	}

	@RequestMapping("/browse")
	public ModelAndView browse() {
		return null;
	}
}
