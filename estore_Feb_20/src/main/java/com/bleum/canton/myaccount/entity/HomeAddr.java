package com.bleum.canton.myaccount.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="MYACC_HOME_ADDRESS")
public class HomeAddr extends BaseEntity {

	private static final long serialVersionUID = -8718760290531218915L;
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "seq_home_addr", sequenceName = "SEQ_MYACC_HOME_ADDRESS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_home_addr")
	private Long id;

	@OneToOne(optional = false)
	@JoinColumn(name = "COUNTRY", nullable = false)
	private Region country;

	@OneToOne(optional = false)
	@JoinColumn(name = "PROVINCE", nullable = false)
	private Region province;

	@OneToOne(optional = false)
	@JoinColumn(name = "CITY", nullable = false)
	private Region city;

	@OneToOne(optional = false)
	@JoinColumn(name = "DISTRICT", nullable = false)
	private Region district;

	@Column(name = "DETAILADDRESS", nullable = false)
	private String detailAddress;

	@Column(name = "ZIPCODE", nullable = false)
	private String zipCode;

	@Column(name = "LINEPHONE", nullable = false)
	private String linePhone;

	@Column(name = "MOBILEPHONE", nullable = false)
	private String mobilePhone;

	@Column(name = "CONTACT", nullable = false)
	private String contact;

	@Column(name = "ISDEFAULT", nullable = false)
	private Integer isDefault;

	@Column(name = "RECENTUSE", nullable = false)
	private Date recentUseDate;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, optional = true)
	@JoinColumn(name = "CUSTOMER")
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
	 * @return the country
	 */
	public Region getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Region country) {
		this.country = country;
	}

	/**
	 * @return the province
	 */
	public Region getProvince() {
		return province;
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(Region province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public Region getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(Region city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public Region getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(Region district) {
		this.district = district;
	}

	/**
	 * @return the detailAddress
	 */
	public String getDetailAddress() {
		return detailAddress;
	}

	/**
	 * @param detailAddress
	 *            the detailAddress to set
	 */
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the isDefault
	 */
	public Integer getIsDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault
	 *            the isDefault to set
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the recentUseDate
	 */
	public Date getRecentUseDate() {
		return recentUseDate;
	}

	/**
	 * @param recentUseDate
	 *            the recentUseDate to set
	 */
	public void setRecentUseDate(Date recentUseDate) {
		this.recentUseDate = recentUseDate;
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
