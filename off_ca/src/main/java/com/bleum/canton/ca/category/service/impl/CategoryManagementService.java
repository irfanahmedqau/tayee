package com.bleum.canton.ca.category.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bleum.canton.ca.category.dao.ICategoryDao;
import com.bleum.canton.ca.category.entity.Category;
import com.bleum.canton.ca.category.service.ICategoryManagementService;

/**
 * @author Wayne.Zhong
 * @created Feb 13, 2012 12:11:39 PM
 */
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

	public List<Category> findCategoriesByParentId(String id) {
		List <Category> categoryList = categoryDao.findCategoriesByParentId(id);
		return categoryList;
	}

	public Category findCategoryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void UpdateCategory(Category category) {
		// TODO Auto-generated method stub

	}
	
}
