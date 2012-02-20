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
@Table(name = "CATA_PRODUCTVARIENT")
public class ProductVarient extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CATA_PRODUCTVARIENT")
	@SequenceGenerator(name = "SEQ_CATA_PRODUCTVARIENT", sequenceName = "SEQ_CATA_PRODUCTVARIENT")
	private int id;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product v_product;

	@Column(name = "VARIENT_ID", nullable = false)
	private int varientID;

	@Column(name = "VARIENT_NAME", nullable = false)
	private String varientName;

	@OneToMany(mappedBy = "pv", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ProductVarientValue> values;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getV_product() {
		return v_product;
	}

	public void setV_product(Product v_product) {
		this.v_product = v_product;
	}

	public int getVarientID() {
		return varientID;
	}

	public void setVarientID(int varientID) {
		varientID = varientID;
	}

	public String getVarientName() {
		return varientName;
	}

	public void setVarientName(String varientName) {
		varientName = varientName;
	}

	public List<ProductVarientValue> getValues() {
		return values;
	}

	public void setValues(List<ProductVarientValue> values) {
		this.values = values;
	}

}
