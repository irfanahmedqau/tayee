package com.bleum.canton.itempage.service;

import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.itempage.entity.Product;

public interface IItempageService {
	
	public Category findCategoryByID(String categoryID);
	public Product findProductByID(String productID);
	public Item findItemByID(String itemID);
	public Item findItemByLabel(String itemLabel);
}
