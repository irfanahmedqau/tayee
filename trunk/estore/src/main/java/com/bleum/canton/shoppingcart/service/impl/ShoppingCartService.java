package com.bleum.canton.shoppingcart.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bleum.canton.shoppingcart.dao.IShoppingCartDao;
import com.bleum.canton.shoppingcart.service.IShoppingCartService;

@Service("shoppingCartService")
public class ShoppingCartService implements IShoppingCartService {

	@Resource(name = "shoppingCartDao")
	private IShoppingCartDao shoppingCartDao;
}
