package com.bleum.canton.myaccount.enumeration;

/**
 * @author rudy.ding
 *
 */
public enum CustomerStatus {
	ACTIVATE_PENDDING,
	NORMAL,
	LOCKED,
	REMOVED;
	
	public CustomerStatus getEnum(int val) {
		for (CustomerStatus status : CustomerStatus.values()) {
			if (status.ordinal() == val) {
				return status;
			}
		}
		throw new IndexOutOfBoundsException("Invalid CustomerStatus ordinal");
	}
}
