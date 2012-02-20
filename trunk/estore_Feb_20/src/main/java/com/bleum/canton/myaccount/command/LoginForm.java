/**
 * 
 */
package com.bleum.canton.myaccount.command;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author rudy.ding
 * 
 */
public class LoginForm {

	@NotBlank(message = "{myacc.csm.loginname_empty}")
	private String loginName;

	@NotBlank(message = "{myacc.csm.pwd_empty}")
	private String password;

	/**
	 * @return the loginName
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

}
