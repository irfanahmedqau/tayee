package com.bleum.canton.myaccount.dao;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.myaccount.entity.Customer;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
public interface ICustomerDao extends BaseDao<Customer>{
	
	/**
	 * validateRegisteredName
	 * @param registeredName
	 * @return Customer
	 */
	public Customer findCustomerByName(String name);
	
	
	
}
