/**
 * 
 */
package com.bleum.canton.myaccount.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author rudy.ding
 * 
 */
public class RegisterForm {

	@NotBlank
	private String loginName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String checkPassword;

	@Email
	private String email;

	/**
	 * @return the customerName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName
	 *            the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the checkPassword
	 */
	public String getCheckPassword() {
		return checkPassword;
	}

	/**
	 * @param checkPassword
	 *            the checkPassword to set
	 */
	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
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

}
