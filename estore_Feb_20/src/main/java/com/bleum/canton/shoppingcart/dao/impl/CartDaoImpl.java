package com.bleum.canton.shoppingcart.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.shoppingcart.dao.ICartDao;
import com.bleum.canton.shoppingcart.entity.Cart;

@Transactional
@Repository("cartDao")
public class CartDaoImpl extends BaseDaoHibernateImpl<Cart> implements ICartDao {

	public Cart findCartByCustomerId(Long customerId) {
		Cart cart = retrieve(customerId);
		return cart;
	}

	@SuppressWarnings("unchecked")
	public Cart findCartByCustomerLoginName(String customerLoginName){
		List<Cart> carts = getSession().createQuery("from Cart c where c.customer.loginName = :loginName")
			.setString("loginName", customerLoginName).list();
		if(carts.size() > 0){
			return carts.get(0);
		}
		return null;
	}
	
	public void saveOrUpdate(Cart cart) {
//		// first load the data
//		Cart c = (Cart)retrieve(cart.getId());
	}
	
	public void deleteCartItemById(Long cartItemId){
		getSession().createQuery("delete from CartItem c where c.id = :id")
					.setLong("id", cartItemId).executeUpdate();
	}
	

}
