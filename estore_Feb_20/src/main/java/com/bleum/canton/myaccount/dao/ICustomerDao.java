package com.bleum.canton.myaccount.dao;

import org.springframework.stereotype.Repository;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.myaccount.entity.Customer;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
@Repository
public interface ICustomerDao extends BaseDao<Customer>{
	
	public Customer findCustomerByLoginName(String loginName);
	
	public Customer findCustomerByEmail(String email);
		
}
