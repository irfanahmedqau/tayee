package com.bleum.canton.itempage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "PRODUCTRICHCONTENT")
public class ProductRichContent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "PRODUCTID", nullable = false)
	private String productID;
	@Column(name = "RCID", nullable = false)
	private String RCID;
	@Column(name = "RCNAME", nullable = false)
	private String RCName;
	@Column(name = "RCVALUE", nullable = false)
	private String RCValue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getRCID() {
		return RCID;
	}

	public void setRCID(String rCID) {
		RCID = rCID;
	}

	public String getRCName() {
		return RCName;
	}

	public void setRCName(String rCName) {
		RCName = rCName;
	}

	public String getRCValue() {
		return RCValue;
	}

	public void setRCValue(String rCValue) {
		RCValue = rCValue;
	}

}
