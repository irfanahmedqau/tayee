package com.bleum.canton.search.bean;

public class Pagination {
	private int paginationGroupSize;
	private int paginationGroups;
	private int currentPaginationGroup;
	private int prePaginationGroupBegin;
	private int nextPaginationGroupBegin;
	private boolean enableGroup;
	private int total;
	private int currentPage = 1;
	private int pageSize;
	private int pages;
	private int begin;
	private int end;

	public int getPaginationGroupSize() {
		return paginationGroupSize;
	}

	public void setPaginationGroupSize(int paginationGroupSize) {
		this.paginationGroupSize = paginationGroupSize;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return this.pages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPaginationGroups() {
		return paginationGroups;
	}

	public void setPaginationGroups(int paginationGroups) {
		this.paginationGroups = paginationGroups;
	}

	public boolean isEnableGroup() {
		return enableGroup;
	}

	public void setEnableGroup(boolean enableGroup) {
		this.enableGroup = enableGroup;
	}

	public void setCurrentPaginationGroup(int currentPaginationGroup) {
		this.currentPaginationGroup = currentPaginationGroup;
	}

	public int getCurrentPaginationGroup() {
		return currentPaginationGroup;
	}

	public int getPrePaginationGroupBegin() {
		return prePaginationGroupBegin;
	}

	public void setPrePaginationGroupBegin(int prePaginationGroupBegin) {
		this.prePaginationGroupBegin = prePaginationGroupBegin;
	}

	public int getNextPaginationGroupBegin() {
		return nextPaginationGroupBegin;
	}

	public void setNextPaginationGroupBegin(int nextPaginationGroupBegin) {
		this.nextPaginationGroupBegin = nextPaginationGroupBegin;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}

	private int getBegin(int group) {
		return (group - 1) * paginationGroupSize + 1;
	}

	private int caculatePages(int total, int pageSize) {
		int pages = total / pageSize;
		pages = total % pageSize == 0 ? pages : pages + 1;
		return pages;
	}

	public void init() {
		pages = caculatePages(total, pageSize);
		if (pages > getPaginationGroupSize() && isEnableGroup()) {
			paginationGroups = caculatePages(pages, getPaginationGroupSize());
			currentPaginationGroup = caculatePages(currentPage, getPaginationGroupSize());
			prePaginationGroupBegin = getBegin(getCurrentPaginationGroup() - 1);
			nextPaginationGroupBegin = getBegin(getCurrentPaginationGroup() + 1);
			nextPaginationGroupBegin = nextPaginationGroupBegin > pages ? -1 : nextPaginationGroupBegin;
			begin = getBegin(getCurrentPaginationGroup());
			end = getBegin() + getPaginationGroupSize() - 1;
			end = end > getPages() ? getPages() : end;
		} else {
			begin = 1;
			end = getPages();
		}
	}
}
