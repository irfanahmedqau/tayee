package com.bleum.canton.checkout.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

@Entity
@Table(name = "Invoice")
public class Invoice extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "TYPE", nullable = false)
	private String type;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "TAX", nullable = false)
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
