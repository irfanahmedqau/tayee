package com.bleum.canton.myaccount.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author lynn.chen
 * @since v 0.1.0 ,Feb 6, 2012
 * @version v 0.1.0
 */
@Entity
@Table(name="MYACC_HOMEADDRESS")
public class HomeAddr extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8718760290531218915L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="")
	private Long id;
	
	@OneToOne(optional=false)
	@JoinColumn(name="COUNTRY",nullable=false)
	private Region country;
	
	@OneToOne(optional=false)
	@JoinColumn(name="PROVINCE",nullable=false)
	private Region province;
	
	@OneToOne(optional=false)
	@JoinColumn(name="CITY",nullable=false)
	private Region city;
	
	@OneToOne(optional=false)
	@JoinColumn(name="DISTRICT",nullable=false)
	private Region district;
	
	@Column(name="DETAILADDRESS",nullable=false)
	private String detailAddress;
	
	@Column(name="ZIPCODE",nullable=false)
	private String zipCode;
	
	@Column(name="LINEPHONE",nullable=false)
	private String linePhone;
	
	@Column(name="MOBILEPHONE",nullable=false)
	private String mobilePhone;
	
	@Column(name="CONTRACTOR",nullable=false)
	private String contacter;
	
	@Column(name="ISDEFAULT",nullable=false)
	private Integer isDefault;
	
	@Column(name="RECENTUSE",nullable=false)
	private Date recentUseDate;

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
	 * @return the contacter
	 */
	public String getContacter() {
		return contacter;
	}

	/**
	 * @param contacter
	 *            the contacter to set
	 */
	public void setContacter(String contacter) {
		this.contacter = contacter;
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


	
	
	

}
