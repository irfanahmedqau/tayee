/**
 * 
 */
package com.bleum.canton.myaccount.command;

import com.bleum.canton.myaccount.enumeration.CustomerStatus;

/**
 * @author rudy.ding
 *
 */
public class CustomerForm {
	
	private Long id;
	
	private String loginName;
	
	private String password;
	
	private String email;
	
	private String description;
	
	private String lastLoginDate;
	
	private CustomerStatus status;
	
	private String nickName;
	
	private String firstName;
	
	private String lastName;
	
	private String birthday;
	
	private Integer gender;
	
	private String linePhone;
	
	private String mobilePhone;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getId() {
		return id;
	}

	public CustomerStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
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
	
}
