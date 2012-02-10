package com.bleum.canton.itempage.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.itempage.dao.ICategoryDao;
import com.bleum.canton.itempage.entity.Category;

@Repository("categoryDaoImpl")
public class CategoryDaoImpl implements ICategoryDao {
	
	@Resource(name="productSessionFactory")
	private SessionFactory sessionFactory;
	
	public Category findById(String categoryID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category)session.get(Category.class, categoryID);
		
		return category;
	}
	
	
}
