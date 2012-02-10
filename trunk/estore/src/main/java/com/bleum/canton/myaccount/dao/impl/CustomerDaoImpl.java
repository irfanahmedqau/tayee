package com.bleum.canton.myaccount.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.myaccount.dao.ICustomerDao;
import com.bleum.canton.myaccount.entity.Customer;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoHibernateImpl<Customer> implements ICustomerDao {
	
	public CustomerDaoImpl() {
		super.init();
	}



	public Customer findCustomerByName(String name) {
		// TODO Auto-generated method stub
		Session  session =  super.getSession();
		Query query = session.createQuery("FROM Customer c WHERE c.LOGINNAME= ?");
		query.setString(0, name);
		return (Customer) query.list().get(0);
	}
	
	
}
