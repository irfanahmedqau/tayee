package com.bleum.canton.sample.command;

import java.util.List;

public class ProductForm {

	private String productName;
	
	private String skuId;
	
	private List<String> storages;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public List<String> getStorages() {
		return storages;
	}

	public void setStorages(List<String> storages) {
		this.storages = storages;
	}

}
