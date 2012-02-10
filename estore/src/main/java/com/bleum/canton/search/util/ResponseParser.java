package com.bleum.canton.search.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.bleum.canton.search.bean.SearchItem;
import com.bleum.canton.search.bean.SearchResult;

/**
 * Parser used to parse solr search result to customized search result
 * 
 * @author hank.guo
 */
public class ResponseParser {
	public static final String CATEGORIEY_FIELD_NAME = "cat";
	private static Map<String, Method> SearchItemMethodMap;

	static {
		SearchItemMethodMap = new HashMap<String, Method>();
		Method[] methods = SearchItem.class.getMethods();
		for (Method m : methods) {
			SearchItemMethodMap.put(m.getName(), m);
		}
	}

	public static SearchResult parse(QueryResponse response) {
		SearchResult result = new SearchResult();
		if (response != null) {
			SolrDocumentList docList = response.getResults();
			result.setTotalCount(Integer.valueOf(docList.getNumFound() + ""));
			result.setItems(parseItems(docList));
		}
		return result;
	}

	public static List<SearchItem> parseItems(SolrDocumentList docList) {
		List<SearchItem> books = new ArrayList<SearchItem>();
		for (int i = 0; i < docList.size(); i++) {
			SearchItem book = new SearchItem();
			SolrDocument doc = docList.get(i);
			Field[] fields = SearchItem.class.getDeclaredFields();
			for (Field f : fields) {
				if (f.isAnnotationPresent(org.apache.solr.client.solrj.beans.Field.class)) {
					String fName = f.getName();
					try {
						Object value = doc.get(fName);
						if (value != null) {
							Method method = SearchItemMethodMap
									.get(SearchUtil.toSetMethodName(fName));
							method.invoke(book, value);
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Field name: " + fName);
					}
				}
			}
			books.add(book);
		}
		return books;
	}
}
