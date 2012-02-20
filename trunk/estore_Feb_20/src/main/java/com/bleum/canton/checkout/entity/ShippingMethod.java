package com.bleum.canton.checkout.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bleum.canton.common.entity.BaseEntity;
@Entity
@Table(name = "CTCO_SHIPPINGMETHOD")
public class ShippingMethod extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="shippingMethodGenerator", sequenceName="SEQ_SHIPPING_METHOD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shippingMethodGenerator")
	private int id;
	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "shipping_expect_date", updatable = false)
	private String shippingExpectDate;
	@Column(name = "shipping_exact_date", updatable = false)
	private Date shippingExactDate;
	@Column(name = "shipping_detailtime", updatable = false)
	private String shippingDetailTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getShippingExactDate() {
		return shippingExactDate;
	}
	public void setShippingExactDate(Date shippingExactDate) {
		this.shippingExactDate = shippingExactDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShippingExpectDate() {
		return shippingExpectDate;
	}
	public void setShippingExpectDate(String shippingExpectDate) {
		this.shippingExpectDate = shippingExpectDate;
	}
	public String getShippingDetailTime() {
		return shippingDetailTime;
	}
	public void setShippingDetailTime(String shippingDetailTime) {
		this.shippingDetailTime = shippingDetailTime;
	}
}
