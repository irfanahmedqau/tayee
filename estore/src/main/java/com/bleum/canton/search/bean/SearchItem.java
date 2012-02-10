package com.bleum.canton.search.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class SearchItem implements Serializable {
	private static final long serialVersionUID = -2300073304405545015L;
	@Field
	private String id;
	@Field
	private String sku;
	@Field
	private String name;
	@Field
	private List<String> cat;
	@Field
	private List<String> features;
	@Field
	private List<String> includes;
	@Field
	private Float price;
	@Field
	private String inStock;
	@Field
	private List<String> title;
	@Field
	private String brand;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCat() {
		return cat;
	}

	public void setCat(List<String> cat) {
		this.cat = cat;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public List<String> getIncludes() {
		return includes;
	}

	public void setIncludes(List<String> includes) {
		this.includes = includes;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public List<String> getTitle() {
		return title;
	}

	public void setTitle(List<String> title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n").append("id").append("=").append(getId()).append("\r\n");
		sb.append("cat").append("=").append(getCat().toString()).append("\r\n");
		sb.append("name").append("=").append(getName().toString()).append("\r\n");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof SearchItem) {
			return this.getId().equals(((SearchItem) obj).getId());
		} else {
			return false;
		}
	}
}
