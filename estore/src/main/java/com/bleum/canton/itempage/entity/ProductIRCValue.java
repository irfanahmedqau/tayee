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
@Table(name = "PRODUCTIRCVALUE")
public class ProductIRCValue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "PRODUCTIRCID", nullable = false)
	private String productIRCID;
	@Column(name = "IRCVALUE")
	private String IRCValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductIRCID() {
		return productIRCID;
	}

	public void setProductIRCID(String productIRCID) {
		this.productIRCID = productIRCID;
	}

	public String getIRCValue() {
		return IRCValue;
	}

	public void setIRCValue(String iRCValue) {
		IRCValue = iRCValue;
	}

}
