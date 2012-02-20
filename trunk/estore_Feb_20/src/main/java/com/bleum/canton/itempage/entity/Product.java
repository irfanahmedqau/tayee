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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "CATA_PRODUCT")
public class Product extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CATA_PRODUCT")
	@SequenceGenerator(name = "SEQ_CATA_PRODUCT", sequenceName = "SEQ_CATA_PRODUCT")
	private int id;

	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category p_category;

	@Column(name = "DESCRIPTION_URL", nullable = false)
	private String descriptionURL;

	@Column(name = "THUMB_IMAGE_URL")
	private String thumbImageURL;
/*
	@OneToMany(mappedBy = "i_product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Item> itemList;
*/
/*
	@OneToMany(mappedBy = "rc_product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<ProductRichContent> RCList;

	@OneToMany(mappedBy = "v_product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<ProductVarient> varientsList;
*/
//	@OneToMany(mappedBy = "rv_product", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//	private List<Varient> rawVarientList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getP_category() {
		return p_category;
	}

	public void setP_category(Category p_category) {
		this.p_category = p_category;
	}

	public String getDescriptionURL() {
		return descriptionURL;
	}

	public void setDescriptionURL(String descriptionURL) {
		this.descriptionURL = descriptionURL;
	}

	public String getThumbImageURL() {
		return thumbImageURL;
	}

	public void setThumbImageURL(String thumbImageURL) {
		this.thumbImageURL = thumbImageURL;
	}
/*
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<ProductRichContent> getRCList() {
		return RCList;
	}

	public void setRCList(List<ProductRichContent> rCList) {
		RCList = rCList;
	}

	public List<ProductVarient> getVarientsList() {
		return varientsList;
	}

	public void setVarientsList(List<ProductVarient> varientsList) {
		varientsList = varientsList;
	}
*/
//	public List<Varient> getRawVarientList() {
//		return rawVarientList;
//	}
//
//	public void setRawVarientList(List<Varient> rawVarientList) {
//		this.rawVarientList = rawVarientList;
//	}

}
