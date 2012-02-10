package com.bleum.canton.itempage.dao;

import com.bleum.canton.itempage.entity.ProductRichContent;

public interface IProductRCDao {
	
	public ProductRichContent getPRCByProductID(String productID);
	public ProductRichContent getPRCByID(String prcID);
}
