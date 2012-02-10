package com.bleum.canton.itempage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "PRODUCTNAME", nullable = false)
	private String productName;

	@ManyToOne
	@JoinColumn(name = "CATEGORY", nullable = false)
	private Category category;

	@Column(name = "DESCRIPTIONURL", nullable = false)
	private String descriptionURL;

	@OneToMany
	@JoinColumn(name = "PRODUCTRICHCONTENT", nullable = false)
	private List<ProductRichContent> RCList;

	@OneToMany
	@JoinColumn(name = "PRODUCTIRC", nullable = false)
	private List<ProductIRC> IRCList;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescriptionURL() {
		return descriptionURL;
	}

	public void setDescriptionURL(String descriptionURL) {
		this.descriptionURL = descriptionURL;
	}

	public List<ProductRichContent> getRCList() {
		return RCList;
	}

	public void setRCList(List<ProductRichContent> rCList) {
		RCList = rCList;
	}

	public List<ProductIRC> getIRCList() {
		return IRCList;
	}

	public void setIRCList(List<ProductIRC> iRCList) {
		IRCList = iRCList;
	}

}
