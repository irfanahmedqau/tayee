package com.bleum.canton.itempage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.checkout.entity.CheckOut;
import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "CATA_PRODUCTRC")
public class ProductRichContent extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CATA_PRODUCTRC")
	@SequenceGenerator(name = "SEQ_CATA_PRODUCTRC", sequenceName = "SEQ_CATA_PRODUCTRC")
	private int id;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product rc_product;
	@Column(name = "RC_ID", nullable = false)
	private int RCID;
	@Column(name = "RC_NAME", nullable = false)
	private String RCName;
	@Column(name = "RC_VALUE", nullable = false)
	private String RCValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getRc_product() {
		return rc_product;
	}

	public void setRc_product(Product rc_product) {
		this.rc_product = rc_product;
	}

	public int getRCID() {
		return RCID;
	}

	public void setRCID(int rCID) {
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
