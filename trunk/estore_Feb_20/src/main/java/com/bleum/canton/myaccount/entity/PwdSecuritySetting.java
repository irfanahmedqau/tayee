package com.bleum.canton.myaccount.entity;

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
 * @since v 0.1.0 ,Feb 6, 2012
 * @version v 0.1.0
 */
@Entity
@Table(name="MYACC_PWD_SECURITY_SETTING")
public class PwdSecuritySetting extends BaseEntity {

	private static final long serialVersionUID = 6999771132514352292L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "seq_pwd_security", sequenceName = "SEQ_MYACC_PWD_SECURITY_SETTING", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pwd_security")
	private Long id;

	@OneToOne(optional = false)
	@JoinColumn(name = "CUSTOMER", nullable = false)
	private Customer customer;

	@Column(name = "QUESTION1")
	private String question1;

	@Column(name = "ANSWER1")
	private String answer1;

	@Column(name = "QUESTION2")
	private String question2;

	@Column(name = "ANSWER2")
	private String answer2;

	@Column(name = "SECURITYEMAIL")
	private String email;

	@Column(name = "MOBILEPHONE")
	private String mobilePhone;

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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the question1
	 */
	public String getQuestion1() {
		return question1;
	}

	/**
	 * @param question1
	 *            the question1 to set
	 */
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	/**
	 * @return the answer1
	 */
	public String getAnswer1() {
		return answer1;
	}

	/**
	 * @param answer1
	 *            the answer1 to set
	 */
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	/**
	 * @return the question2
	 */
	public String getQuestion2() {
		return question2;
	}

	/**
	 * @param question2
	 *            the question2 to set
	 */
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	/**
	 * @return the answer2
	 */
	public String getAnswer2() {
		return answer2;
	}

	/**
	 * @param answer2
	 *            the answer2 to set
	 */
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

}
