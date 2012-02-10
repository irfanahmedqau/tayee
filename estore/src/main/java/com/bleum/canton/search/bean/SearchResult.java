package com.bleum.canton.search.bean;

import java.io.Serializable;
import java.util.List;

import com.bleum.canton.search.command.SearchForm;

public class SearchResult implements Serializable {
	private static final long serialVersionUID = 7179112862090429353L;

	public List<SearchItem> getItems() {
		return this.items;
	}

	public void setItems(List<SearchItem> items) {
		this.items = items;
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public SearchForm getQuery() {
		return this.query;
	}

	public void setQuery(SearchForm query) {
		this.query = query;
	}

	private List<SearchItem> items;
	private long totalCount;
	private SearchForm query;
}
