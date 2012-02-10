package com.bleum.canton.itempage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "ITEMLABEL", nullable = false)
	private String ItemLabel;

	@Column(name = "ITEMNAME", nullable = false)
	private String ItemName;

	@Column(name = "PRICE", nullable = false)
	private long price;

	@Column(name = "STOCKLEFT", nullable = false)
	private int stockLeft;

	@OneToMany
	@JoinColumn(name = "ITEMIMAGE", nullable = false)
	private List<ItemImage> images;

	@ManyToOne
	@JoinColumn(name = "PRODUCT", nullable = false)
	private Product product;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemLabel() {
		return ItemLabel;
	}

	public void setItemLabel(String itemLabel) {
		ItemLabel = itemLabel;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getStockLeft() {
		return stockLeft;
	}

	public void setStockLeft(int stockLeft) {
		this.stockLeft = stockLeft;
	}

	public List<ItemImage> getImages() {
		return images;
	}

	public void setImages(List<ItemImage> images) {
		this.images = images;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
