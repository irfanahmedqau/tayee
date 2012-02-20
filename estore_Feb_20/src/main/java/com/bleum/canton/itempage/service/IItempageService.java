package com.bleum.canton.itempage.service;

import java.util.List;

import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.itempage.entity.Product;
import com.bleum.canton.itempage.entity.ProductRichContent;
import com.bleum.canton.itempage.entity.ProductVarient;

public interface IItempageService {
	
	public Category getCategoryByID(String categoryID);
	public Category getParentCategory(String categoryID);
	public List<Category> getChildCategories(String categoryID);
	public List<Category> getCategoryTreeFromProduct(Product product);
	public List<String> getChildCategoryIDs(String categoryID);
	
	public Product getProductByID(int productID);
	public List<Product> findProductByCategoryID(String categoryID);
	
	public Item getItemByLabel(String itemLabel);
	public Item getDefaultItemByProductID(int productID);
	public List<Item> getRequiredItems(int[] itemIDs);
	
	public List<ProductRichContent> getRichContentByProductID(int productid);
	
	public List<ProductVarient> getProductVarientByProductID(int productid);
	
	


}
