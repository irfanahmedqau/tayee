package com.bleum.canton.checkout.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;
@Entity
@Table(name = "ItemCollecion")
public class CheckOutItemDetail extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "PRODUCT_ITEM_ID", nullable = false)
	private int productItemId;
	@ManyToOne
	@JoinColumn(name = "CHECKOUT_ITEM_ID", nullable = false)
	private CheckOut checkOut;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductItemId() {
		return productItemId;
	}
	public void setProductItemId(int productItemId) {
		this.productItemId = productItemId;
	}
	public CheckOut getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(CheckOut checkOut) {
		this.checkOut = checkOut;
	}
}
