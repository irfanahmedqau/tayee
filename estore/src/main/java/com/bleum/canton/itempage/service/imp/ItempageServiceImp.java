package com.bleum.canton.itempage.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.itempage.dao.ICategoryDao;
import com.bleum.canton.itempage.dao.IItemDao;
import com.bleum.canton.itempage.dao.IProductDao;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.itempage.entity.Product;
import com.bleum.canton.itempage.service.IItempageService;

@Component("itempageServiceImp")
public class ItempageServiceImp implements IItempageService{
	
	@Autowired
	private ICategoryDao categoryDaoImpl;
	@Autowired
	private IItemDao itemDaoImpl;
	@Autowired
	private IProductDao productDaoImpl;
	
	
	@Transactional
	public Category findCategoryByID(String categoryID){
		return categoryDaoImpl.findById(categoryID);
	}
	
	@Transactional
	public Product findProductByID(String productID){
		return productDaoImpl.findById(productID);
	}
	
	@Transactional
	public Item findItemByID(String itemID){
		return itemDaoImpl.findById(itemID);
	}
	
	@Transactional
	public Item findItemByLabel(String itemLabel){
		return itemDaoImpl.findByItemLabel(itemLabel);
	}
	
}
