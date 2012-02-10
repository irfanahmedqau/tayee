/**
 * 
 */
package com.bleum.canton.myaccount.command;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author rudy.ding
 * 
 */
public class HomeAddrForm {
	
	private Long id;

	@NotBlank
	private RegionForm country;
	
	@NotBlank
	private RegionForm province;
	
	@NotBlank
	private RegionForm city;
	
	@NotBlank
	private RegionForm district;
	
	@NotBlank
	private String detailAddress;
	
	private String zipCode;
	
	private String linePhone;
	
	private String mobilePhone;
	
	@NotBlank
	private String contacter;
	
	private Boolean isDefault;
	
	private Date recentUseDate;

	public Long getId() {
		return id;
	}

	public RegionForm getCountry() {
		return country;
	}

	public void setCountry(RegionForm country) {
		this.country = country;
	}

	public RegionForm getProvince() {
		return province;
	}

	public void setProvince(RegionForm province) {
		this.province = province;
	}

	public RegionForm getCity() {
		return city;
	}

	public void setCity(RegionForm city) {
		this.city = city;
	}

	public RegionForm getDistrict() {
		return district;
	}

	public void setDistrict(RegionForm district) {
		this.district = district;
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

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
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
	
}
