package com.bleum.canton.search.dao;

import com.bleum.canton.search.bean.SearchResult;
import com.bleum.canton.search.command.SearchForm;

public interface ISearchDao {
	SearchResult query(SearchForm form) throws Exception;
}
