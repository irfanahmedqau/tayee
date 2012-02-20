package com.bleum.canton.shoppingcart.service;


import com.bleum.canton.shoppingcart.entity.Cart;

public interface IShoppingCartService {
	
	
	/**
	 * Add a specified number of Item into Cart
	 * 
	 * @param itemId id of the item which will be added to cart
	 * @param quantityToBeAdd the quantity for adding, passing negative number for deleting
	 * @param cart target shopping cart 
	 * 
	 * @return true if the specified quantity of items is successfully be added
	 * */
	public Cart addItemToCart(final int itemId, int quantityToBeAdd, final Cart cart);

	
	/**
	 * Update the quantity of cart item to a specified number 
	 * 
	 * @param cardItemId 
	 * @param quantityForUpdating the quantity to be updated to
	 * @param cart target shopping cart 
	 * 
	 * @return Cart the modified Cart
	 * */
	public Cart updateCartItemForCart(final long cartItemId, int quantityForUpdating, final Cart cart);
	
	
	/**
	 * load Cart information for current user
	 * 
	 * @param customerLoginName current user, if customerLoginName is null, means it's a guest
	 * 
	 * @return Cart belongs to the given customer
	 * */
	public Cart loadCart(final String customerLoginName);
	
	/**
	 * persistent given cart
	 * 
	 * @param cart cart to be persisted
	 * 
	 * @return void
	 * 
	 * */
	public void persistCart(final Cart cart);
	
	/**
	 * remove a specified item entry from cart
	 * 
	 * @param cartItemId  cartItem id
	 * @param cart target cart
	 * 
	 * 
	 * @return Cart the modified Cart
	 * */
	public Cart removeCartItemFromCart(long cartItemId, final Cart cart);
	
	/**
	 * remove all item entries in this cart object
	 * 
	 * @param cart target cart
	 * 
	 * @return Cart the modified Cart
	 * */
	public Cart removeAllCartItems(final Cart cart);
	
	/**
	 * merge items' information in transient cart(customer purchase items when he/she is not login) with
	 * items' information persistent cart when customer login
	 * 
	 * @param transientCart customers use transient cart to store item's information when they browsing
	 * e-store as guest, the transient information could be stored in Cookie, Session, or DB
	 * 
	 * @return Cart cart after merging
	 * */
	public Cart mergeCart(final Cart transientCart);

}
