package com.bleum.canton.itempage.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;

//@Transactional
//@DAO(name="itemDaoImpl")
public interface IItemDao{

	public Item findById(int itemID);
	public Item findByItemLabel(String itemLabel);
	public List<Item> findItemByProductID(int productID);
}
