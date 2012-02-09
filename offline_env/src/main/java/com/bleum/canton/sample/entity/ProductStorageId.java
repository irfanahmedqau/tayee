package com.bleum.canton.sample.entity;

import java.io.Serializable;

/**
 * Composite Id class for the entity class ProductStorage.
 * @author 	sandro.xu
 * @since	v 0.1.0, 1/30/2012
 * @version	0.1.0
 *
 */
public class ProductStorageId implements Serializable {

	private static final long serialVersionUID = 6620992177748617701L;
	
	private String productId;
	
	private String storageId;
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

}
