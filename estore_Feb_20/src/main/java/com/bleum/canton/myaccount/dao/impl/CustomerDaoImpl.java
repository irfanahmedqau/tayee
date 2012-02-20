package com.bleum.canton.myaccount.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.myaccount.dao.ICustomerDao;
import com.bleum.canton.myaccount.entity.Customer;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends BaseDaoHibernateImpl<Customer> implements ICustomerDao {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	public CustomerDaoImpl() {
		super.init();
	}

	public Customer findCustomerByLoginName(String loginName) {
		Query query = getSession().getNamedQuery("Customer.findByLoginName").setString("loginName", loginName);
		List<Customer> results = query.list();
		if( results != null && !results.isEmpty()) {
			return results.get(0);
		}
		logger.debug("No customer found by login name: " + loginName);
		return null;
	}
	
	public Customer findCustomerByEmail(String email) {
		Query query = getSession().getNamedQuery("Customer.findByEmail").setString("email", email);
		List<Customer> results = query.list();
		if( results != null && !results.isEmpty()) {
			return results.get(0);
		}
		logger.debug("No customer found by email: " + email);
		return null;
	}
	
	
}
