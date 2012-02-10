package com.bleum.canton.search.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bleum.canton.search.bean.SearchResult;
import com.bleum.canton.search.command.SearchForm;
import com.bleum.canton.search.dao.ISearchDao;
import com.bleum.canton.search.service.ISearchService;

@Service("searchService")
public class SearchServiceImpl implements ISearchService {
	private final Logger logger = LoggerFactory.getLogger(XMLIndexServiceImpl.class);

	@Resource(name = "searchDao")
	private ISearchDao searchDao;

	public SearchResult query(SearchForm form) throws Exception {
		return searchDao.query(form);
	}
}
