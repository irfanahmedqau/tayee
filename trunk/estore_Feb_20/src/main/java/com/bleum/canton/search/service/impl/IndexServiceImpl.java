package com.bleum.canton.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Product;
import com.bleum.canton.itempage.service.IItempageService;
import com.bleum.canton.search.bean.SearchItem;
import com.bleum.canton.search.config.SearchConnectionFactory;
import com.bleum.canton.search.service.IIndexService;

@Service("indexService")
public class IndexServiceImpl implements IIndexService {
	private final Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);

	@Resource(name = "itempageServiceImpl")
	private IItempageService itemPageServiceImpl;

	@Resource(name = "searchConnectionFactory")
	private SearchConnectionFactory searchConnectionFactory;

	private final String ROOT_CAT_ID = "cata_root";

	private final Map<String, Category> catMap = new HashMap<String, Category>();

	public void clear() {
		catMap.clear();
		searchConnectionFactory.clear();
		searchConnectionFactory.commit();
	}

	public void delete(Collection<String> ids) {

	}

	public void createIndex() throws Exception {
		SolrServer server = searchConnectionFactory.getSolrServer();
		if (catMap.isEmpty()) {
			loadCategory(ROOT_CAT_ID);
		}
		for (String catId : catMap.keySet()) {
			List<Product> plist = itemPageServiceImpl.findProductByCategoryID(catId);
			if (plist != null && !plist.isEmpty()) {
				indexProduct(server, plist);
			}
		}
		searchConnectionFactory.commit();
	}

	public void loadCategory(String catId) {
		Category cat = itemPageServiceImpl.getCategoryByID(catId);
		processCategory(cat);
		List<Category> childCats = itemPageServiceImpl.getChildCategories(catId);
		if (childCats != null && !childCats.isEmpty()) {
			cat.setChildren(childCats);
			for (Category c : childCats) {
				if (!catId.equalsIgnoreCase(c.getId())) {
					c.setParent(cat);
					processCategory(cat);
					loadCategory(c.getId());
				}
			}
		}
	}

	private void processCategory(Category cat) {
		if (ROOT_CAT_ID.equalsIgnoreCase(cat.getId())) {
			cat.setFullName("/" + cat.getCategoryName());
		} else {
			Category p = cat.getParent();
			if (p != null) {
				cat.setFullName(p.getFullName() + "/" + cat.getCategoryName());
			}
		}
		catMap.put(cat.getId(), cat);
	}

	private void indexProduct(SolrServer server, List<Product> plist) {
		try {
			server.addBeans(convertAsIndexItem(plist));
		} catch (SolrServerException e) {
			logger.warn("Failed to index products for [" + productIds(plist) + "]", e);
		} catch (IOException e) {
			logger.warn("Failed to index products for [" + productIds(plist) + "]", e);
		}
	}

	private String productIds(List<Product> plist) {
		StringBuilder sb = new StringBuilder();
		for (Product p : plist) {
			sb.append(p.getId()).append(",");
		}
		return sb.toString();
	}

	private List<SearchItem> convertAsIndexItem(List<Product> plist) {
		List<SearchItem> indexList = new ArrayList<SearchItem>();
		for (Product p : plist) {
			if (p != null) {
				indexList.add(convertAsIndexItem(p));
			}
		}
		return indexList;
	}

	private SearchItem convertAsIndexItem(Product product) {
		SearchItem indexItem = new SearchItem();
		indexItem.setId(product.getId() + "");
		indexItem.setName(product.getProductName());
		indexItem.setImageUrl(product.getThumbImageURL());
		return indexItem;
	}
}
