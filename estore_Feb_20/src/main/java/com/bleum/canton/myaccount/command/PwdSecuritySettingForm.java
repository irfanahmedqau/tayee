/**
 * 
 */
package com.bleum.canton.myaccount.command;

/**
 * @author rudy.ding
 *
 */
public class PwdSecuritySettingForm {
	
	private Long id;
	
	private CustomerForm customer;
	
	private String question1;
	
	private String answer1;
	
	private String question2;
	
	private String answer2;
	
	private String email;
	
	private String mobilePhone;

	public CustomerForm getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerForm customer) {
		this.customer = customer;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
