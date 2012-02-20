package com.bleum.canton.itempage.dao;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
import com.bleum.canton.itempage.entity.Category;

//@Transactional
//@DAO(name="categoryDaoImpl")
public interface ICategoryDao{
	
	public Category findById(String categoryID);
}
