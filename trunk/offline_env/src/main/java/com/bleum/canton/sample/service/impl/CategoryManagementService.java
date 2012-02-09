package com.bleum.canton.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bleum.canton.ca.util.ExtHelper;
import com.bleum.canton.sample.dao.ICategoryDao;
import com.bleum.canton.sample.entity.Category;
import com.bleum.canton.sample.service.ICategoryManagementService;

@Service("categoryManagementService")
public class CategoryManagementService implements ICategoryManagementService {
	
	@Resource(name="categoryDao")
	private ICategoryDao categoryDao;

	public void addCategory(Category category) {
		// TODO Auto-generated method stub

	}

	public void delCategory() {
		// TODO Auto-generated method stub

	}

	public List<Category> findCategoryByParId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Category findCategoryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void UpdateCategory(Category category) {
		// TODO Auto-generated method stub

	}

	public String getCategoryJSON(String parentId) {
		// TODO Auto-generated method stub
		List <Category> categoryList = categoryDao.findCategoryByParId(parentId);
		String json = ExtHelper.listToJsonArray(categoryList);
		return json;
	}

}
