package com.bleum.canton.common.dao;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bleum.canton.myaccount.dao.ICustomerDao;
import com.bleum.canton.myaccount.entity.Customer;

public class DaoTest extends TestCase {
	private ApplicationContext factory;

	public DaoTest(String s) {
		super(s);
		factory = new ClassPathXmlApplicationContext(
				"com/bleum/canton/app-global-config-test.xml");
	}

	public void xtestInterfaceDao() throws Exception {
		ICustomerDao customerDao = (ICustomerDao) factory.getBean("customerDao");

		assertNotNull(customerDao);

		Customer customer = customerDao.findCustomerByLoginName("xx");

		assertNull(customer);
	}
	
	public void testDynamicRegisterDao() throws Exception {
		ICustomerDao customerDao = (ICustomerDao) factory.getBean("customerDao");

		assertNotNull(customerDao);

		Customer customer = customerDao.findCustomerByEmail("xx");

		assertNull(customer);
	}
}
