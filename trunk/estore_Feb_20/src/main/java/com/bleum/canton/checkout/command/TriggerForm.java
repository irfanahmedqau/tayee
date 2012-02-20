package com.bleum.canton.checkout.command;

import com.bleum.canton.checkout.constant.CheckOutConst;

public class TriggerForm {

	private String customerID;
	private String itemList;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getItemList() {
		return itemList;
	}

	public void setItemList(String itemList) {
		this.itemList = itemList;
	}

	public int[] getAllItems() {
		String split = CheckOutConst.SPLIT_SYMBOL;
		String[] result_s = this.itemList.split(split);
		int[] result_i = new int[result_s.length];
		for (int i = 0; i < result_s.length; i++) {
			result_i[i] = Integer.valueOf(result_s[i]);
		}
		return result_i;
	}
}
