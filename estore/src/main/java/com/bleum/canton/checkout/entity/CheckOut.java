package com.bleum.canton.checkout.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

@Entity
@Table(name = "CheckOut")
public class CheckOut extends BaseEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "CUSTOMER_ID", nullable = false)
	private int customerId;
	@OneToOne(optional = false)
	@JoinColumn(name = "PAYMENT_METHOD_ID", nullable = false)
	private PaymentMethod paymentMethod;
	@OneToOne(optional = false)
	@JoinColumn(name = "SHIPPING_METHOD_ID", nullable = false)
	private ShippingMethod shippingMethod;
	@Column(name = "AMOUNT", nullable = false)
	private double amount;
	@OneToMany(mappedBy = "checkOut", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<CheckOutItemDetail> itemCollection;
	@OneToOne(optional = false)
	@JoinColumn(name = "INVOICE_ID", nullable = false)
	private Invoice invoice;
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public int getId() {
		return id;
	}
	public List<CheckOutItemDetail> getItemCollection() {
		return itemCollection;
	}
	public void setItemCollection(List<CheckOutItemDetail> itemCollection) {
		this.itemCollection = itemCollection;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
