package com.bleum.canton.itempage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.itempage.dao.ICategoryDao;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Product;

//@Repository("categoryDaoImpl")
@Component("categoryDaoImpl")
public class CategoryDaoImpl {

	@Resource(name = "catalogSessionFactory")
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public Category findById(String categoryID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session
				.createQuery("FROM Category as cate WHERE cate.id=:id");
		query.setString("id", categoryID);

		return (Category) query.list().get(0);
	}
	
	@Transactional
	public Category getParentCategory(String categoryID) {
		Category category = findById(categoryID);
		String parentID = category.getParentID();
		if(!parentID.equals(categoryID)){
			Session session = getSession();
			Query query = session
					.createQuery("FROM Category as cate WHERE cate.id=?");
			query.setString(0, parentID);
			
			return (Category)query.list().get(0);
		}
		else
			return category;
	}
	
	@Transactional
	public List<Category> getChildCategories(String categoryID) {
		Session session = getSession();
		Query query = session.createQuery("FROM Category as cate WHERE cate.parentID=?");
		query.setString(0, categoryID);
		List<Category> childList = query.list();
		if(childList.size()<1)
			childList.add(findById(categoryID));
		
		return childList;
	}
	
	@Transactional
	public List<Category> getCategoryTreeFromProduct(Product product){
		List<Category> tempList = new ArrayList<Category>();
		Category category = product.getP_category();
		tempList.add(category);
		Category parentCategory;
		while(true){
			parentCategory = getParentCategory(category.getId());
			if(!category.equals(parentCategory)){
				tempList.add(parentCategory);
				category = parentCategory;
			}
			else
				break;
		}
		tempList.get(tempList.size()-1).setCategoryName("首页");
		
		List<Category> resultList = new ArrayList<Category>();
		for(int i=tempList.size()-1;i>=0;i--)
			resultList.add(tempList.get(i));
		
		return resultList;
	}
	
	@Transactional
	public List<String> getChildCategoryIDs(String categoryID){
		List<Category> categoryList = getChildCategories(categoryID);
		List<String> ids = new ArrayList<String>();
		for(Category category:categoryList)
			ids.add(category.getId());
		
		return ids;
	}
}
