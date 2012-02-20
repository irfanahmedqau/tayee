package com.bleum.canton.search.service;

import java.util.Collection;

public interface IIndexService {

	void clear();

	void delete(Collection<String> ids);

	void createIndex() throws Exception;
}
