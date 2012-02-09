package com.bleum.canton.sample.service;

import java.util.List;

import com.bleum.canton.sample.entity.Category;

public interface ICategoryManagementService {
	public void addCategory(Category category);
	
	public void delCategory();
	
	public List <Category> findCategoryByParId(String id);
	
	public Category findCategoryById(String id);
	
	public void UpdateCategory(Category category);
	
	public String getCategoryJSON(String parentId);
}
