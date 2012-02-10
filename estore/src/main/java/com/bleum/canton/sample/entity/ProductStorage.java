package com.bleum.canton.sample.entity;

import java.io.Serializable;

/**
 * Entity class. Each object maintains the relationship about a specific kind of product with a available storage.
 * @author 	sandro.xu
 * @since	v 0.1.0, 1/30/2012
 * @version	0.1.0
 * 
 */
public class ProductStorage implements Serializable {

	private static final long serialVersionUID = 6772765586313896399L;
	

	public ProductStorage() {
		this.id = new ProductStorageId();
	}
	
	/*
	 * The class just has one attribute - the composite id.
	 * In the real scenario, this kind of class may has other attributes.
	 */
	private ProductStorageId id;

	public ProductStorageId getId() {
		return id;
	}

	public void setId(ProductStorageId id) {
		this.id = id;
	}

}
