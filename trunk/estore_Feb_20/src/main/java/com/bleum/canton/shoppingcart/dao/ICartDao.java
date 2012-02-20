package com.bleum.canton.shoppingcart.dao;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.shoppingcart.entity.Cart;


public interface ICartDao extends BaseDao<Cart>{
	
	/**
	 * find related cart from persistent layer by given customer 
	 * 
	 * @param customerId primary key for customer
	 * 
	 * @return Cart 
	 * */
	public Cart findCartByCustomerId(Long customerId);
	
	/**
	 * find related cart from persistent layer by given customer
	 * the cart state should not be completed 
	 * 
	 * @param customerLoginName customer login name
	 * 
	 * @return Cart 
	 * */
	public Cart findCartByCustomerLoginName(String customerLoginName);
	
	/**
	 * Save the cart information persistent layer if it's a new cart, otherwise, update it
	 * 
	 * @param cart target cart
	 * 
	 * @return void
	 * */
	public void saveOrUpdate(Cart cart);
	
	/**
	 * delete related CartItem from persistent layer by given cartItem 
	 * 
	 * @param cartItemId primary key for CartItem
	 * 
	 * @return void 
	 * */
	public void deleteCartItemById(Long cartItemId);
	

}
