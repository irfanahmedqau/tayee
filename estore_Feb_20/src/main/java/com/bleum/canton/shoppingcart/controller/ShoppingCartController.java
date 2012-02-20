package com.bleum.canton.shoppingcart.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.shoppingcart.entity.Cart;
import com.bleum.canton.shoppingcart.entity.CartItem;
import com.bleum.canton.shoppingcart.service.IShoppingCartService;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	
	private final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	@Resource(name = "shoppingCartService")
	private IShoppingCartService shoppingCartService;

	/**
	 * remove a item in cart, should replace with AJAX
	 * */
	@RequestMapping(value = "/remove/{cartItemId}")
	public ModelAndView removeCartItem(@PathVariable(value = "cartItemId") Long cartItemId,
			HttpSession session) {
		System.out.println(cartItemId);
		Cart myCart = getAndInitMyCart(session);
		myCart = shoppingCartService.removeCartItemFromCart(cartItemId, myCart);

		return renderMAV(myCart);
	}
	
	/**
	 * remove all cart items, should replace with AJAX
	 * */
	@RequestMapping(value = "/removeAll", method = RequestMethod.POST)
	public ModelAndView removeAllCartItem(@PathVariable(value = "cartItemId") Long cartItemId,
			HttpServletRequest request) throws Exception{
		Cart myCart = getAndInitMyCart(request.getSession());
		myCart = shoppingCartService.removeAllCartItems(myCart);
      
	  return renderMAV(myCart);
	}

	/**
	 * update a item's quantity in cart,should replace with AJAX
	 * */
	@RequestMapping(value = "/update/{cartItemId}", method = RequestMethod.POST)
	public ModelAndView updateItem(@PathVariable(value = "cartItemId") Long cartItemId,
			@Valid Integer quantity, HttpSession session) {
		Cart myCart = getAndInitMyCart(session);
		myCart = shoppingCartService.updateCartItemForCart(cartItemId, quantity, myCart);

	
		return renderMAV(myCart);
	}

	/**
	 * The cart main page , should replace with AJAX
	 * */
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView displayAll(HttpSession session) {

		return renderMAV(getAndInitMyCart(session));
	}
	
	private Cart getAndInitMyCart(HttpSession session){
		Cart myCart = (Cart) session.getAttribute("myCart");
		if (null == myCart) {
//			 String customerLoginName = (String)session.getAttribute("customerLoginName");
			 String customerLoginName = "aaaaaaaa";
			 myCart = shoppingCartService.loadCart(customerLoginName);
			// mock
//			myCart = this.mockCart();		
			session.setAttribute("myCart",myCart);
		}	
		return myCart;
	}
	
	private ModelAndView renderMAV(Cart myCart) {
		ModelAndView mav = new ModelAndView();
		List<CartItem> itemList = myCart.getCartItems();
		// use BigDecimal instead later
		double totalPrice = 0;
		for (CartItem item : itemList) {
			System.out.println(item.getItemName());
			System.out.println(item.getQuantity());
//			totalPrice = totalPrice + item.getItem().getPrice();
			totalPrice = 100;
		}
//		for (CartItem cartItem : itemList) {
//			totalPrice = totalPrice + cartItem.getItem().getPrice();
//		}
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("itemList", itemList);
		mav.setViewName("shoppingcart/cart");
		return mav;
	}
	
	private Cart mockCart(){
		Cart cart = new Cart();
		
		Item item1 = new Item();
		item1.setId(100);
		item1.setItemName("itemA");
		item1.setPrice(20);
		CartItem cartItem1 = new CartItem(item1,2,cart);
		
		Item item2 = new Item();
		item2.setId(101);
		item2.setItemName("itemB");
		item2.setPrice(10);
		CartItem cartItem2 = new CartItem(item2,1,cart);
		cart.getCartItems().add(cartItem1);
		cart.getCartItems().add(cartItem2);	
		return cart;
	}

}
