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
@Table(name = "CTCO_INVOICE")
public class Invoice extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="invoiceGenerator", sequenceName="SEQ_INVOICE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="invoiceGenerator")
	private int id;
	@Column(name = "TYPE", nullable = false)
	private String type;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "TAX")
	private String tax;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
