package com.bleum.canton.shoppingcart.entity;

public enum CartState {
	
	// The state when customer is not login
	TRANSIENT,
	// The normal state when customer login
	NORMAL,
	// There are items in cart which state is OUTOFSTOCK or REMOVED
	EXCEPTION,
	// The Cart is already checked out as Order 
	COMPELETED,
	// The Cart is removed by system automatically by clean strategy  
	REMOVED

}
