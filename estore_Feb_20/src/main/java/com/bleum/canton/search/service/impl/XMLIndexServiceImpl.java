package com.bleum.canton.search.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bleum.canton.search.config.SearchConnectionFactory;
import com.bleum.canton.search.service.IIndexService;
import com.bleum.canton.search.util.SearchUtil;

@SuppressWarnings("unchecked")
@Service("xmlIndexService")
public class XMLIndexServiceImpl implements IIndexService {
	private final Logger logger = LoggerFactory.getLogger(XMLIndexServiceImpl.class);

	private static final String FILE_EXTENSION = "xml";

	@Resource(name = "searchConnectionFactory")
	private SearchConnectionFactory searchConnectionFactory;

	private String dataDir = "D:/Canton/svn/Common/Codebase/trunk/estore/src/test/resources/com/bleum/canton/search";

	public void clear() {
		searchConnectionFactory.clear();
		searchConnectionFactory.commit();
	}

	public void optimize() {
		searchConnectionFactory.optimize();
	}

	public void delete(Collection<String> ids) {
		StringBuilder bs = new StringBuilder();
		bs.append("<delete>");
		for (String id : ids) {
			bs.append("<id>");
			bs.append(id);
			bs.append("/<id>");
		}
		bs.append("/<delete>");
		try {
			searchConnectionFactory.post(bs.toString());
		} catch (HttpException e) {
			logger.error("HttpExceptin when do delete", e);
		} catch (IOException e) {
			logger.error("IOException when do delete", e);
		}
	}

	public void createIndex() throws FileNotFoundException {
		String[] extensions = new String[] { FILE_EXTENSION };
		Collection<File> files = FileUtils.listFiles(SearchUtil.getFile(getDataDir()), extensions, false);
		for (File f : files) {
			try {
				searchConnectionFactory.post(new FileInputStream(f));
			} catch (HttpException e) {
				logger.error("HttpExceptin when do createIndex", e);
			} catch (IOException e) {
				logger.error("IOException when do createIndex", e);
			}
		}
		searchConnectionFactory.commit();
	}

	public String getDataDir() {
		return dataDir;
	}

	public void setDataDir(String dataDir) {
		this.dataDir = dataDir;
	}
}
