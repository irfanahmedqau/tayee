package com.bleum.canton.shoppingcart.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.bleum.canton.shoppingcart.dao.impl.CartDaoImpl;


public class CartDaoImplTest {
	
	private ApplicationContext factory;
	
	@Before
	public void setUp(){
		factory = new ClassPathXmlApplicationContext(
				"com/bleum/canton/app-global-config-test.xml");
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void test(){
		CartDaoImpl cartDao = (CartDaoImpl) factory.getBean("cartDao");
		Assert.notNull(cartDao);
		
	}
	
	

}
