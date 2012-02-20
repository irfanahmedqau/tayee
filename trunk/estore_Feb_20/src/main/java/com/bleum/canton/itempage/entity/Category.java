package com.bleum.canton.itempage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */

@Entity
@Table(name = "CATA_CATEGORY")
public class Category extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "CATEGORY_NAME", nullable = false)
	private String categoryName;

	@Column(name = "PARENT_ID", nullable = false)
	private String parentID;

	@Column(name = "CATEGORY_LEVEL", nullable = false)
	private int level;
	/*
	 * @OneToMany(mappedBy = "p_category", cascade = CascadeType.PERSIST, fetch
	 * = FetchType.EAGER)
	 * private List<Product> productList;
	 */
	//	@OneToMany(mappedBy = "rc_category", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	//	private List<RichContent> rcList;

	@Transient
	private Category parent;

	@Transient
	private String fullName;

	@Transient
	private List<Category> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	/*
	 * public List<Product> getProductList() {
	 * return productList;
	 * }
	 * public void setProductList(List<Product> productList) {
	 * this.productList = productList;
	 * }
	 */
	//	public List<RichContent> getRcList() {
	//		return rcList;
	//	}
	//
	//	public void setRcList(List<RichContent> rcList) {
	//		this.rcList = rcList;
	//	}

}
