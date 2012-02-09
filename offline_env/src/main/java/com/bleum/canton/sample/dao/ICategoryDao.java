package com.bleum.canton.sample.dao;

import java.util.List;

import com.bleum.canton.sample.entity.Category;

public interface ICategoryDao {
	public void addCategory(Category category);
	
	public void delCategory();
	
	public List <Category> findCategoryByParId(String id);
	
	public Category findCategoryById(String id);
	
	public void UpdateCategory(Category category);
}
