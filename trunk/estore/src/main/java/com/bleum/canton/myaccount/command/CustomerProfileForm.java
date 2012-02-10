/**
 * 
 */
package com.bleum.canton.myaccount.command;

import java.util.Date;

/**
 * @author rudy.ding
 *
 */
public class CustomerProfileForm {
	
	private Long id;
	
	private String nickName;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthday;
	
	private Integer gender;
	
	private String email;
	
	private String linePhone;
	
	private String mobilePhone;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getId() {
		return id;
	}
	
}
