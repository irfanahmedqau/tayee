package com.bleum.canton.ca.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.ca.dao.ICategoryDao;
import com.bleum.canton.ca.entity.Category;

@Repository("categoryDao")
public class CategoryDao implements ICategoryDao {
	
	@Resource(name = "productSessionFactory")
	private SessionFactory sessionFactory;

	public void addCategory(Category category) {
		// TODO Auto-generated method stub

	}

	public void delCategory() {
		// TODO Auto-generated method stub

	}

	public List<Category> findCategoryByParId(String id) {
		Category cat1 = new Category();
		cat1.setCategoryID("01111");
		cat1.setCategoryName("婴儿用品");
		cat1.setLevel("1");
		cat1.setParentID(null);
		Category cat2 = new Category();
		cat2.setCategoryID("01112");
		cat2.setCategoryName("婴儿用品");
		cat2.setLevel("1");
		cat2.setParentID(null);
		Category cat3 = new Category();
		cat3.setCategoryID("01112");
		cat3.setCategoryName("婴儿用品");
		cat3.setLevel("1");
		cat3.setParentID(null);
		List <Category> categoryList = new ArrayList<Category> ();
		categoryList.add(cat1);
		categoryList.add(cat2);
		categoryList.add(cat3);
		// TODO Auto-generated method stub
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
