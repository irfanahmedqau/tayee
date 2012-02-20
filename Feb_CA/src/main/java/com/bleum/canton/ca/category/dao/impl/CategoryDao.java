package com.bleum.canton.ca.category.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.ca.category.dao.ICategoryDao;
import com.bleum.canton.ca.category.entity.Category;

@Repository("categoryDao")
public class CategoryDao implements ICategoryDao {
	
	@Resource(name = "versionedSessionFactory")
	private SessionFactory sessionFactory;

	@Transactional
	public void addCategory(Category category)throws HibernateException {
	    Session session = sessionFactory.getCurrentSession();
	    session.save(category);
	    session.flush(); 
	}

	public void delCategory() {
		// TODO Auto-generated method stub

	}
	
	@Transactional
	@SuppressWarnings("unchecked")
    public List<Category> findCategoriesByParentId(String id) {
	    Session session = sessionFactory.getCurrentSession();
	    String categoryHQL = " from Category as categroy where categroy.parentID =:ID ";
	    Query query = session.createQuery(categoryHQL); 
	    query.setParameter("ID", id);
	    List <Category> categoryList =  query.list(); 
		return categoryList;
	}
	
	@Transactional
    @SuppressWarnings("unchecked")
	public List<Category> findCategoriesByLevel(String level){
	    Session session = sessionFactory.getCurrentSession();
	    String categoryHQL = " from Category as category where category.level =:level ";
	    Query query = session.createQuery(categoryHQL);
	    query.setParameter("level", level);
	    List <Category> categoryList = query.list();
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
