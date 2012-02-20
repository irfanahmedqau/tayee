package com.bleum.canton.shoppingcart.enumeration;

public enum CartStatus {
	
	// The state when customer is not login
	TRANSIENT,
	// The normal state when customer login
	NORMAL,
	// There are items in cart which state is OUTOFSTOCK or REMOVED
	EXCEPTION,
	// The Cart is already checked out as Order 
	COMPELETED,
	// The Cart is removed by system automatically by clean strategy  
	REMOVED;
	
	public CartStatus getEnum(int val){
		for(CartStatus status: CartStatus.values()){
			if(status.ordinal() == val){
				return status;
			}
		}
		throw new IndexOutOfBoundsException("Invalid CartStatus ordinal");
	}

}
