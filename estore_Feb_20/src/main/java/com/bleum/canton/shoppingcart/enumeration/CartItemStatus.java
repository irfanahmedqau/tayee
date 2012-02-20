package com.bleum.canton.shoppingcart.enumeration;

public enum CartItemStatus {
	
	// the item in Cart is ok
	NORMAL,
	// the item in Cart is out of stock
	OUTOFSTOCK,
	// the item in Cart is already removed from stock
	ROMOVED;
	
	public CartItemStatus getEnum(int val){
		for(CartItemStatus status: CartItemStatus.values()){
			if(status.ordinal() == val){
				return status;
			}
		}
		throw new IndexOutOfBoundsException("Invalid CartItemStatus ordinal");
	}

}
