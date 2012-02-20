package com.bleum.canton.shoppingcart.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.shoppingcart.dao.ICartItemDao;
import com.bleum.canton.shoppingcart.entity.CartItem;

@Transactional
@Repository("cartItemDao")
public class CartItemDaoImpl extends BaseDaoHibernateImpl<CartItem> implements ICartItemDao {
	

}
