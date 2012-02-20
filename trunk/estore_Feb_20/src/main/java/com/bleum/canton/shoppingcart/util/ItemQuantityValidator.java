package com.bleum.canton.shoppingcart.util;

public class ItemQuantityValidator {
	
	//hard code first
	public static boolean isValid(int quantity){
		if ( quantity >= 0 && quantity < 1000){
			return true;
		}
		return false;
	}

}
