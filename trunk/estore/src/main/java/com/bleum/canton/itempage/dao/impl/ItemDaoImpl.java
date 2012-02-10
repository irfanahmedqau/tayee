package com.bleum.canton.itempage.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bleum.canton.itempage.dao.IItemDao;
import com.bleum.canton.itempage.entity.Item;

@Repository("itemDaoImp")
public class ItemDaoImpl implements IItemDao {
	
	@Resource(name="productSessionFactory")
	private SessionFactory sessionFactory;
	
	public Item findById(String ItemID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Item item = (Item)session.get(Item.class, ItemID);
		
		return item;
	}

	public Item findByItemLabel(String itemLabel) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Item item = (Item)session.get(Item.class, itemLabel);
		
		return item;
	}

}
