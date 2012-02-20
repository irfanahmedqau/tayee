package com.bleum.canton.shoppingcart.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.itempage.dao.impl.ItemDaoImpl;
import com.bleum.canton.myaccount.dao.ICustomerDao;
import com.bleum.canton.shoppingcart.dao.ICartDao;
import com.bleum.canton.shoppingcart.dao.ICartItemDao;
import com.bleum.canton.shoppingcart.entity.Cart;
import com.bleum.canton.shoppingcart.entity.CartItem;
import com.bleum.canton.shoppingcart.service.IShoppingCartService;
import com.bleum.canton.shoppingcart.util.ItemQuantityValidator;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements IShoppingCartService {

	@Resource(name = "cartDao")
	private ICartDao cartDao;
	
	@Resource(name = "cartItemDao")
	private ICartItemDao cartItemDao;
	
	@Resource(name = "itemDaoImpl")
	private ItemDaoImpl itemDao;
	
	@Resource(name = "customerDao")
	private ICustomerDao customerDao;

	/**
     * {@inheritDoc}
     */
	@Transactional
	public Cart addItemToCart(final int itemId, int quantityToBeAdd, final Cart cart){
		
		// item already exists in cart? then just update the quantity
		for (CartItem cartItem : cart.getCartItems()){
			if(cartItem.getItemId() == itemId){
	
				return updateCartItemForCart(cartItem.getId(), cartItem.getQuantity() +  quantityToBeAdd,cart);	
			}
		}
		// add new item to Cart
//		CartItem newCartItem = new CartItem(itemDao.findById(itemId), quantityToBeAdd, cart);
//		cart.getCartItems().add(newCartItem);
		return cart;
	}
	
    /**
     * {@inheritDoc}
     */
	@Transactional
	public Cart updateCartItemForCart(final long cartItemId, int quantityForUpdating, final Cart cart){
		if(!ItemQuantityValidator.isValid(quantityForUpdating)){
			// should throw Exception here instead?
			return cart;
		}
		if(0 != quantityForUpdating){
			findCartItemInCart(cartItemId, cart).setQuantity(quantityForUpdating);
			//persistCart(cart);
			return cart;
		}else{
			return removeCartItemFromCart(cartItemId, cart);
		}
	}
	
	
    /**
     * {@inheritDoc}
     */
	@Transactional
	public Cart loadCart(final String customerLoginName){
		Cart cart = null;
		//if it is a guest, create new one for customer
		if(null == customerLoginName){
           	cart  = new Cart();		
		}		
		cart = cartDao.findCartByCustomerLoginName(customerLoginName);
		// if no cart was found, create one for current customer
		if(null == cart){
			cart = new Cart();
			cart.setCustomer(customerDao.findCustomerByLoginName(customerLoginName));
		}
		return cart;		
	}
	
    /**
     * {@inheritDoc}
     */
	@Transactional
	public void persistCart(final Cart cart){
		// this part may involves many DAO actions,beside update the Cart Data in DB, we also need to
	    // maintain the CartItem info in the Cart, some CartItem may be added, some may be deleted.
		// CASCADE may works.
		cartDao.saveOrUpdate(cart);
	}
	
    /**
     * {@inheritDoc}
     */
	@Transactional
	public Cart removeCartItemFromCart(long cartItemId, final Cart cart){		
		cart.getCartItems().remove(findCartItemInCart(cartItemId, cart));		
//		persistCart(cart);
		cartDao.deleteCartItemById(cartItemId);
		return cart;
	}
    /**
     * {@inheritDoc}
     */
	@Transactional
	public Cart removeAllCartItems(final Cart cart){
		cart.getCartItems().clear();
		 
		//persistCart(cart);
		return cart;
	}
	
    /**
     * {@inheritDoc}
     */
	@Transactional
	public Cart mergeCart(final Cart transientCart){
		
		return null;		
	}

	
	private CartItem findCartItemInCart(Long cartItemId, final Cart cart){
		for(CartItem cartItem : cart.getCartItems()){
			if(cartItem.getId() == cartItemId){
				return cartItem;
			}
		}
		return null;
	}	
	
}
