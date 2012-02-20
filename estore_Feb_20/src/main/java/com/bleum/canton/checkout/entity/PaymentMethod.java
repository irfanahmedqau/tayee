package com.bleum.canton.checkout.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

@Entity
@Table(name = "CTCO_PAYMENTMETHOD")
public class PaymentMethod extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="paymentMethodGenerator", sequenceName="SEQ_PAYMENT_METHOD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paymentMethodGenerator")
	private int id;
	@Column(name = "Name", nullable = false)
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
