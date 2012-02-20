package com.bleum.canton.myaccount.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author lynn.chen
 * @since v 0.1.0 ,Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name="MYACC_CUSTOMER_PROFILE")
public class CustomerProfile extends BaseEntity {

	private static final long serialVersionUID = -8768009952226283729L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "seq_profile", sequenceName = "SEQ_MYACC_CUSTOMER_PROFILE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profile")
	private Long id;

	@Column(name = "NICKNAME")
	private String nickName;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "BIRTHDAY")
	private Timestamp birthday;

	@Column(name = "GENDER")
	private Integer gender;

	@Column(name = "LINEPHONE")
	private String linePhone;

	@Column(name = "MOBILEPHONE")
	private String mobilePhone;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER", unique=true)
	private Customer customer;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthday
	 */
	public Timestamp getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the gender
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * @return the linePhone
	 */
	public String getLinePhone() {
		return linePhone;
	}

	/**
	 * @param linePhone
	 *            the linePhone to set
	 */
	public void setLinePhone(String linePhone) {
		this.linePhone = linePhone;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone
	 *            the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
