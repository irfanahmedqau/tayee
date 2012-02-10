package com.bleum.canton.sample.command;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class ProductForm {

	@NotBlank(message = "{product.name.error.empty}")
	private String productName;
	
	@NotBlank(message = "{product.skuid.error.empty}")
	@Pattern(regexp = "^P\\d{5}$", message = "{product.skuid.error.pattern}")
	private String skuId;
	
	@NotNull(message = "{product.storages.error.null}")
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
