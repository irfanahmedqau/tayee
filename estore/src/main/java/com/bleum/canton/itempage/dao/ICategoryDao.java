package com.bleum.canton.itempage.dao;

import com.bleum.canton.itempage.entity.Category;

public interface ICategoryDao {
	
	public Category findById(String categoryID);
}
