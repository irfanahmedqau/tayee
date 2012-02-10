package com.bleum.canton.common.dao;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bleum.canton.sample.dao.CustomerDao;
import com.bleum.canton.sample.entity.SampleCustomer;

public class DaoTest extends TestCase {
	private ApplicationContext factory;

	public DaoTest(String s) {
		super(s);
		factory = new ClassPathXmlApplicationContext(
				"com/bleum/canton/app-global-config-test.xml");
	}

	public void testInterfaceDao() throws Exception {
		CustomerDao customerDao = (CustomerDao) factory.getBean("customerDao");

		assertNotNull(customerDao);

		SampleCustomer customer = customerDao.findById(1L);

		assertNull(customer);
	}

	public void testUserImplementedDao() throws Exception {

		CustomerDao customerDao = (CustomerDao) factory
				.getBean("userImplementedCustomerDao");

		assertNotNull(customerDao);

		SampleCustomer customer = customerDao.findByEmail("email");

		assertNull(customer);
	}
	
	public void testDynamicRegisterDao() throws Exception {
		CustomerDao customerDao = (CustomerDao) factory.getBean("CustomerDao");

		assertNotNull(customerDao);

		SampleCustomer customer = customerDao.findById(1L);

		assertNull(customer);
	}
}
