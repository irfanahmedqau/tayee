/**
 * 
 */
package com.bleum.canton.myaccount.command;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

/**
 * @author rudy.ding
 * 
 */
public class HomeAddrForm {
	
	private Long id;

	@NotBlank(message="myaccount.region.not_empty")
	@NumberFormat
	private Long countryId;
	
	@NotBlank(message="myaccount.region.not_empty")
	@NumberFormat
	private Long provinceId;
	
	@NotBlank(message="myaccount.region.not_empty")
	@NumberFormat
	private Long cityId;
	
	@NotBlank(message="myaccount.region.not_empty")
	@NumberFormat
	private Long districtId;
	
	@NotBlank(message="myaccount.homeaddr.detail_not_empty")
	private String detailAddress;
	
//	@Pattern(regexp="^\\d+$",message="myaccount.homeaddr.zipcode_wrong_format")
	@NumberFormat
	private String zipCode;
	
	private String linePhone;
	
	private String mobilePhone;
	
	@NotBlank
	private String contact;
	
	private Boolean isDefault;
	
	private Date recentUseDate;

	public Long getId() {
		return id;
	}


	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLinePhone() {
		return linePhone;
	}

	public void setLinePhone(String linePhone) {
		this.linePhone = linePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Date getRecentUseDate() {
		return recentUseDate;
	}

	public void setRecentUseDate(Date recentUseDate) {
		this.recentUseDate = recentUseDate;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}



	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}



	/**
	 * @return the provinceId
	 */
	public Long getProvinceId() {
		return provinceId;
	}



	/**
	 * @param provinceId the provinceId to set
	 */
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}



	/**
	 * @return the cityId
	 */
	public Long getCityId() {
		return cityId;
	}



	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}



	/**
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}



	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	
	
	
}
