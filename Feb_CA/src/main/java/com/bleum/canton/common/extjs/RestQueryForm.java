package com.bleum.canton.common.extjs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * It's a common form to map the parameters which will be 
 * sent by ExtJS RESTful proxy.
 * @author 	sandro.xu
 * @version	1.0
 * @since	2/16/2012, V 1.0
 *
 */
public class RestQueryForm {
	
	private static final Logger logger = LoggerFactory.getLogger(RestQueryForm.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();

	/*
	 *	Page Size - how many rows for each page 
	 */
	private Integer limit;
	
	/*
	 * 	Target Page Number
	 */
	private Integer page;
	
	/*
	 *  Row Number of The Start One
	 */
	private Integer start;
	
	/*
	 * 	Only-writable field. JSON String of Query Filters. E.g, 
	 * 	[{"property":"userName","value":"Thomas"},{"property":"age","value":"30"}]
	 */
	private String filter;
	
	/*
	 * 	Only-writable field. JSON String of Sort Setting. E.g, 
	 * 	[{"property":"userName","direction":"ASC"},{"property":"age","direction":"DESC"}]
	 */
	private String sort;
	
	/*
	 * 	Only-readable field. It's parsed from the field filter.
	 */
	private List<QueryFilter> queryFilters;
	
	/*
	 * 	Only-readable field. It's parsed from the field sort.
	 */
	private List<QuerySort> querySorts;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public List<QueryFilter> getQueryFilters() {
		return queryFilters;
	}

	public List<QuerySort> getQuerySorts() {
		return querySorts;
	}

	public void setFilter(String filter) {
		this.filter = filter;
		if(this.filter != null && !this.filter.trim().equals("")){
			try {
				this.queryFilters = mapper.readValue(this.filter, new TypeReference<List<QueryFilter>>(){});
			} catch (JsonParseException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (JsonMappingException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if(queryFilters == null) {
			this.queryFilters = new LinkedList<QueryFilter>();
		}
	}

	public void setSort(String sort) {
		this.sort = sort;
		if(this.sort != null && !this.sort.trim().equals("")){
			try {
				this.querySorts = mapper.readValue(this.sort, new TypeReference<List<QuerySort>>(){});
			} catch (JsonParseException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (JsonMappingException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		if(querySorts == null) {
			this.querySorts = new LinkedList<QuerySort>();
		}
	}

}
