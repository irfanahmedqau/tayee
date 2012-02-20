package com.bleum.canton.itempage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "CATA_ITEM")
public class Item extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CATA_ITEM")
	@SequenceGenerator(name = "SEQ_CATA_ITEM", sequenceName = "SEQ_CATA_ITEM")
	private int id;

	@Column(name = "ITEM_LABEL", nullable = false)
	private String itemLabel;

	@Column(name = "ITEM_NAME", nullable = false)
	private String itemName;

	@Column(name = "PRICE", nullable = false)
	private double price;

	@Column(name = "STOCKLEFT", nullable = false)
	private int stockLeft;

	@OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemImage> images;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product i_product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(String itemLabel) {
		itemLabel = itemLabel;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public Product getI_product() {
		return i_product;
	}

	public void setI_product(Product i_product) {
		this.i_product = i_product;
	}

}
