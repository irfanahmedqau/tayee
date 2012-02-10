package com.bleum.canton.itempage.dao;

import com.bleum.canton.itempage.entity.ProductIRC;
import com.bleum.canton.itempage.entity.ProductRichContent;

public interface IProductIRCDao {
	
	public ProductIRC getPIRCByID(String productIRCID);
	public ProductIRC getPIRCByProductID(String productID);
	
}
