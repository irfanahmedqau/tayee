package com.bleum.canton.sample.entity;

import java.io.Serializable;

/**
 * Entity Class which stores the basic information of product.
 * @author 	sandro.xu
 * @since	v 0.1.0, 1/30/2012
 * @version	0.1.0
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 8076661344696551125L;
	
	private String id;
	
	private String productName;
	
	private String skuId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}
