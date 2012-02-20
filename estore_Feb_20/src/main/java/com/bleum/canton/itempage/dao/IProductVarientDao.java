package com.bleum.canton.itempage.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.ProductVarient;

//@Transactional
//@DAO(name="productVarientDaoImpl")
public interface IProductVarientDao{
	
	public ProductVarient findPVByID(int productVarientID);
	public List<ProductVarient> findPVByProductID(int productID);
	
}
