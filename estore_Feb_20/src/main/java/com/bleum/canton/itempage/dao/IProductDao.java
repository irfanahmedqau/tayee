package com.bleum.canton.itempage.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.itempage.entity.Product;

//@Transactional
//@DAO(name="productDaoImpl")
public interface IProductDao{
	
	public Product findById(int productID);
	public List<Product> findProductByCategoryID(int categoryID);

}
