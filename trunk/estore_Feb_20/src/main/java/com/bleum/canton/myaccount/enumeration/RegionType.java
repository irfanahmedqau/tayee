/**
 * 
 */
package com.bleum.canton.myaccount.enumeration;

/**
 * @author rudy.ding
 * 
 */
public enum RegionType {
	COUNTRY, 
	PROVINCE, 
	CITY, 
	REGION;

	public static RegionType getEnum(int val) {
		for (RegionType type : RegionType.values()) {
			if (type.ordinal() == val) {
				return type;
			}
		}
		throw new IndexOutOfBoundsException("Invalid RegionType ordinal");
	}
}
