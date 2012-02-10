package com.bleum.canton.search.command;

public class SearchForm {
	private String keyWord;
	private String category;
	private int page = 1;
	private int pageSize = 12;
	private String[] fq;

	public String getKeyWord() {
		return this.keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getOffset() {
		return (getPage() - 1) * getPageSize();
	}

	public String[] getFq() {
		return fq;
	}

	public void setFq(String[] fq) {
		this.fq = fq;
	}

}
