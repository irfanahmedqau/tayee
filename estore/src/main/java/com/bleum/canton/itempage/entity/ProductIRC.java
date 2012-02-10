package com.bleum.canton.itempage.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "PRODUCTIRC")
public class ProductIRC implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "PRODUCTID", nullable = false)
	private String productID;

	@Column(name = "IRCID", nullable = false)
	private String IRCID;

	@Column(name = "IRCNAME", nullable = false)
	private String IRCName;

	@OneToMany
	@JoinColumn(name = "PRODUCTIRCVALUE", nullable = false)
	private List<ProductIRCValue> values;

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

	public String getIRCID() {
		return IRCID;
	}

	public void setIRCID(String iRCID) {
		IRCID = iRCID;
	}

	public String getIRCName() {
		return IRCName;
	}

	public void setIRCName(String iRCName) {
		IRCName = iRCName;
	}

	public List<ProductIRCValue> getValues() {
		return values;
	}

	public void setValues(List<ProductIRCValue> values) {
		this.values = values;
	}

}
