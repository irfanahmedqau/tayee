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
import com.bleum.canton.itempage.dao.IItemDao;
import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;

//@Repository("itemDaoImpl")
@Component("itemDaoImpl")
public class ItemDaoImpl {

	@Resource(name = "catalogSessionFactory")
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public Item findById(int ItemID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM Item as i WHERE i.id = ?");
		query.setInteger(0, ItemID);
		
		return (Item) query.list().get(0);
	}
	
	@Transactional
	public Item findByItemLabel(String itemLabel) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session
				.createQuery("FROM Item as i WHERE i.itemLabel = ?");
		query.setString(0, itemLabel);

		return (Item) query.list().get(0);
	}
	
	@Transactional
	public List<Item> findItemByProductID(int productID) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("FROM Item as i WHERE i.i_product = ?");
		query.setInteger(0, productID);
		
		return query.list();
	}
	
	@Transactional
	public List<Item> getRequiredItems(int[] itemIDs) {
		Session session = getSession();
		List<Item> itemList = new ArrayList<Item>();
		Query query = session.createQuery("FROM Item as i WHERE i.id=?");
		for (int itemID : itemIDs) {
			query.setInteger(0, itemID);
			if (query.list() != null && query.list().size() > 0) {
				itemList.add((Item) query.list().get(0));
			}
		}
		return itemList;

	}
}
