package com.bleum.canton.itempage.dao;

import com.bleum.canton.itempage.entity.Item;

public interface IItemDao {

	public Item findById(String itemID);
	public Item findByItemLabel(String itemLabel);
}
