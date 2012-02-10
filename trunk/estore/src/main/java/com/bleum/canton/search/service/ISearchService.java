package com.bleum.canton.search.service;

import com.bleum.canton.search.bean.SearchResult;
import com.bleum.canton.search.command.SearchForm;

public interface ISearchService {
	SearchResult query(SearchForm query) throws Exception;
}
