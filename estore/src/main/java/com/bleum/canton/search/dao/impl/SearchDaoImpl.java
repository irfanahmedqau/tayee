package com.bleum.canton.search.dao.impl;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.search.bean.SearchResult;
import com.bleum.canton.search.command.SearchForm;
import com.bleum.canton.search.config.SearchConnectionFactory;
import com.bleum.canton.search.dao.ISearchDao;
import com.bleum.canton.search.util.ResponseParser;

@Repository("searchDao")
public class SearchDaoImpl implements ISearchDao {
	private final Logger logger = LoggerFactory.getLogger(SearchDaoImpl.class);

	@Resource(name = "searchConnectionFactory")
	private SearchConnectionFactory searchConnectionFactory;

	public SearchResult query(SearchForm form) throws Exception {
		SolrQuery query = new SolrQuery();
		QueryResponse response = null;

		query.setQuery(form.getKeyWord());
		query.setStart(form.getOffset());
		query.setRows(form.getPageSize());

		response = searchConnectionFactory.getSolrServer().query(query);
		SearchResult result = ResponseParser.parse(response);
		result.setQuery(form);
		return result;
	}

}
