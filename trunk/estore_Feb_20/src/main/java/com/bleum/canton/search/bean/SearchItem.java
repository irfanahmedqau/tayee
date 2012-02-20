package com.bleum.canton.search.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class SearchItem implements Serializable {
	private static final long serialVersionUID = -2300073304405545015L;
	@Field
	private String id;
	@Field
	private String name;
	@Field
	private String title;
	@Field
	private String imageUrl;
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
	private String brand;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getCat() {
		return this.cat;
	}

	public void setCat(List<String> cat) {
		this.cat = cat;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<String> getFeatures() {
		return this.features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public List<String> getIncludes() {
		return this.includes;
	}

	public void setIncludes(List<String> includes) {
		this.includes = includes;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getInStock() {
		return this.inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n").append("id").append("=").append(getId()).append("\r\n");
		sb.append("cat").append("=").append(getCat()).append("\r\n");
		sb.append("name").append("=").append(getName()).append("\r\n");
		sb.append("title").append("=").append(getTitle()).append("\r\n");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
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
