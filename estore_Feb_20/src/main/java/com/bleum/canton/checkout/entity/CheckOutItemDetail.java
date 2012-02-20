package com.bleum.canton.checkout.entity;

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

@Entity
@Table(name = "CTCO_ITEMCOLLECTION")
public class CheckOutItemDetail extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "checkOutItemGenerator", sequenceName = "SEQ_CHECKOUT_ITEM_COLLECTION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkOutItemGenerator")
	private int id;
	@Column(name = "PRODUCT_ITEM_ID", nullable = false)
	private String productItemId;
	@ManyToOne
	@JoinColumn(name = "CHECKOUT_ITEM_ID", nullable = false)
	private CheckOut checkOut;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(String productItemId) {
		this.productItemId = productItemId;
	}

	public CheckOut getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(CheckOut checkOut) {
		this.checkOut = checkOut;
	}
}
