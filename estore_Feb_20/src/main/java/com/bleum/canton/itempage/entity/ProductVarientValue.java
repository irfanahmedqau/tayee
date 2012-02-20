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

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "CATA_PRODUCTVARIENTVALUE")
public class ProductVarientValue extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_CATA_PRODUCTVARIENTVALUE")
	@SequenceGenerator(name = "SEQ_CATA_PRODUCTVARIENTVALUE",sequenceName="SEQ_CATA_PRODUCTVARIENTVALUE")
	private int id;

	@ManyToOne
	@JoinColumn(name = "PV_ID", nullable = false)
	private ProductVarient pv;
	@Column(name = "PV_VALUE")
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductVarient getProductVarient() {
		return pv;
	}

	public void setProductVarient(ProductVarient pv) {
		this.pv = pv;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
