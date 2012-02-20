package com.bleum.canton.checkout.command;

public class CheckOutForm {
	private String province;
	private String city;
	private String area;
	private String street;
	private String zipcode;
	private String phone;
	private String shippingArriveOption;
	private String shippingDate;
	private String payType;
	private String invoiceTypeOption;
	private String invoiceUseOption;
	private String invoiceContentOption;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShippingArriveOption() {
		return shippingArriveOption;
	}
	public void setShippingArriveOption(String shippingArriveOption) {
		this.shippingArriveOption = shippingArriveOption;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getInvoiceTypeOption() {
		return invoiceTypeOption;
	}
	public void setInvoiceTypeOption(String invoiceTypeOption) {
		this.invoiceTypeOption = invoiceTypeOption;
	}
	public String getInvoiceUseOption() {
		return invoiceUseOption;
	}
	public void setInvoiceUseOption(String invoiceUseOption) {
		this.invoiceUseOption = invoiceUseOption;
	}
	public String getInvoiceContentOption() {
		return invoiceContentOption;
	}
	public void setInvoiceContentOption(String invoiceContentOption) {
		this.invoiceContentOption = invoiceContentOption;
	}
}
