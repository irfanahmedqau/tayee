package com.bleum.canton.itempage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "CATA_VARIENT")
public class Varient extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CATA_VARIENT")
	@SequenceGenerator(name = "SEQ_CATA_VARIENT", sequenceName = "SEQ_CATA_VARIENT")
	private int id;

	@Column(name = "VARIENT_NAME", nullable = false)
	private String varientName;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "PRODUCT_ID", nullable = false)
//	private Product rv_product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVarientName() {
		return varientName;
	}

	public void setVarientName(String varientName) {
		varientName = varientName;
	}

//	public Product getRv_product() {
//		return rv_product;
//	}
//
//	public void setRv_product(Product rv_product) {
//		this.rv_product = rv_product;
//	}

}
