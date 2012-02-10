package com.bleum.canton.search.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class SearchConnectionFactory {
	private final Logger logger = LoggerFactory.getLogger(SearchConnectionFactory.class);
	private String host;
	private String port;
	private String context;
	private final HttpConnectionManager connectionManager;

	public SearchConnectionFactory() {
		connectionManager = new MultiThreadedHttpConnectionManager();
	}

	public HttpClient getHttpClient() {
		return new HttpClient(connectionManager);
	}

	public void commit() {
		get("commit=true");
	}

	public void clear() {
		try {
			post("<delete><query>*:*</query></delete>");
		} catch (HttpException e) {
			logger.error("HttpExceptin when do clear", e);
		} catch (IOException e) {
			logger.error("IOException when do clear", e);
		}
	}

	public void optimize() {
		get("optimize=true");
	}

	public SolrServer getSolrServer() throws MalformedURLException {
		return new CommonsHttpSolrServer(getServerUrl());
	}

	private GetMethod getUpdateGetMethod() {
		return new GetMethod(getUpdateServerUrl());
	}

	private PostMethod getUpdatePostMethod() {
		return new PostMethod(getUpdateServerUrl());
	}

	public void get(String queryString) {
		try {
			HttpMethod commit = getUpdateGetMethod();
			commit.setQueryString(queryString);
			getHttpClient().executeMethod(commit);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void post(InputStream content) throws HttpException, IOException {
		PostMethod post = getUpdatePostMethod();
		post.addRequestHeader("Content-Type", "application/xml");
		post.setRequestBody(content);
		getHttpClient().executeMethod(post);
	}

	@SuppressWarnings("deprecation")
	public void post(String content) throws HttpException, IOException {
		PostMethod post = getUpdatePostMethod();
		post.addRequestHeader("Content-Type", "application/xml");
		post.setRequestBody(content);
		getHttpClient().executeMethod(post);
	}

	public String getUpdateServerUrl() {
		return getServerUrl() + "/update";
	}

	public String getServerUrl() {
		return getHost() + ":" + getPort() + "/" + getContext();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
