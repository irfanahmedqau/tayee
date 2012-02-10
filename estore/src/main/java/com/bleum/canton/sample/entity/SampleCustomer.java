package com.bleum.canton.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

@Entity
@Table(name="SampleCustomer")
@NamedQueries({
	@NamedQuery(name="SampleCustomer.findById",query="from SampleCustomer c where c.id = :id"),
	@NamedQuery(name="SampleCustomer.findByEmail",query="from SampleCustomer e where e.email = :email")
})
public class SampleCustomer extends BaseEntity {

	@Id
	@SequenceGenerator(name="customer_GENERATOR", sequenceName="CUSTOMER_SEQ" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_GENERATOR")
	@Column(name="id")
	private Long id;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="email")
	private String email;

    public SampleCustomer() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}