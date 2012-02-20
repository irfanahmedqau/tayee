package com.bleum.canton.search.bean;

import java.io.Serializable;
import java.util.List;

import com.bleum.canton.search.command.SearchForm;

public class SearchResult implements Serializable {
	private static final long serialVersionUID = 7179112862090429353L;

	private List<SearchItem> items;
	private int totalCount;
	private SearchForm query;
	private Pagination pagination;

	public List<SearchItem> getItems() {
		return this.items;
	}

	public void setItems(List<SearchItem> items) {
		this.items = items;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public SearchForm getQuery() {
		return this.query;
	}

	public void setQuery(SearchForm query) {
		this.query = query;
	}

	public Pagination getPagination() {
		if (pagination == null) {
			pagination = new Pagination();
			pagination.setCurrentPage(getQuery().getPage());
			pagination.setPageSize(getQuery().getPageSize());
			pagination.setTotal(getTotalCount());
			pagination.setPaginationGroupSize(3);
			pagination.setEnableGroup(true);
			pagination.init();
		}
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
