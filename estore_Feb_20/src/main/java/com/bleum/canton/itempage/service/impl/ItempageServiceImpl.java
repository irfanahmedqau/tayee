package com.bleum.canton.itempage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.itempage.dao.ICategoryDao;
import com.bleum.canton.itempage.dao.IItemDao;
import com.bleum.canton.itempage.dao.IProductDao;
import com.bleum.canton.itempage.dao.impl.CategoryDaoImpl;
import com.bleum.canton.itempage.dao.impl.ItemDaoImpl;
import com.bleum.canton.itempage.dao.impl.ProductDaoImpl;
import com.bleum.canton.itempage.dao.impl.ProductRCDaoImpl;
import com.bleum.canton.itempage.dao.impl.ProductVarientDaoImpl;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.itempage.entity.Product;
import com.bleum.canton.itempage.entity.ProductRichContent;
import com.bleum.canton.itempage.entity.ProductVarient;
import com.bleum.canton.itempage.service.IItempageService;

@Component("itempageServiceImpl")
public class ItempageServiceImpl implements IItempageService {

	@Autowired
	private CategoryDaoImpl categoryDao;
	@Autowired
	private ItemDaoImpl itemDao;
	@Autowired
	private ProductDaoImpl productDao;
	@Autowired
	private ProductRCDaoImpl productRCDao;
	@Autowired
	private ProductVarientDaoImpl productVarientDao;
	
	
	@Transactional
	public Category getCategoryByID(String categoryID) {
		return categoryDao.findById(categoryID);
	}

	@Transactional
	public Category getParentCategory(String categoryID) {
		// TODO Auto-generated method stub
		return categoryDao.getParentCategory(categoryID);
	}

	@Transactional
	public List<Category> getChildCategories(String categoryID) {
		// TODO Auto-generated method stub
		return categoryDao.getChildCategories(categoryID);
	}

	@Transactional
	public List<Category> getCategoryTreeFromProduct(Product product) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryTreeFromProduct(product);
	}

	@Transactional
	public List<String> getChildCategoryIDs(String categoryID) {
		// TODO Auto-generated method stub
		return categoryDao.getChildCategoryIDs(categoryID);
	}

	@Transactional
	public Product getProductByID(int productID) {
		// TODO Auto-generated method stub
		return productDao.findById(productID);
	}

	@Transactional
	public List<Product> findProductByCategoryID(String categoryID) {
		// TODO Auto-generated method stub
		return productDao.findProductByCategoryID(categoryID);
	}

	@Transactional
	public Item getItemByLabel(String itemLabel) {
		return itemDao.findByItemLabel(itemLabel);
	}

	@Transactional
	public Item getDefaultItemByProductID(int productID) {
		// TODO Auto-generated method stub
		return itemDao.findItemByProductID(productID).get(0);
	}

	@Transactional
	public List<Item> getRequiredItems(int[] itemIDs) {
		// TODO Auto-generated method stub
		return itemDao.getRequiredItems(itemIDs);
	}

	public List<ProductRichContent> getRichContentByProductID(int productid) {
		// TODO Auto-generated method stub
		return productRCDao.findPRCByProductID(productid);
	}

	public List<ProductVarient> getProductVarientByProductID(int productid) {
		// TODO Auto-generated method stub
		return productVarientDao.findPVByProductID(productid);
	}

}
