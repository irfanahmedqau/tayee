package com.bleum.canton.itempage.dao;

import com.bleum.canton.itempage.entity.Product;

public interface IProductDao {
	
	public Product findById(String productID);
}
