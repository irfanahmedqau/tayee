package com.bleum.canton.itempage.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.ProductRichContent;

//@Transactional
//@DAO(name="productRCDaoImpl")
public interface IProductRCDao{
	
	public ProductRichContent findPRCByID(int prcID);
	public List<ProductRichContent> findPRCByProductID(int productID);
	
}
