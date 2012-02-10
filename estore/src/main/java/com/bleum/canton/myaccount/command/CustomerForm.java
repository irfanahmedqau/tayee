/**
 * 
 */
package com.bleum.canton.myaccount.command;

import java.util.Date;
import java.util.List;

/**
 * @author rudy.ding
 *
 */
public class CustomerForm {
	
	private Long id;
	
	private String loginName;
	
	private String password;
	
	private CustomerProfileForm profile;
	
	private List<HomeAddrForm> homeAddrs;
	
	private String description;
	
	private Date lastLoginDate;

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

	public CustomerProfileForm getProfile() {
		return profile;
	}

	public void setProfile(CustomerProfileForm profile) {
		this.profile = profile;
	}

	public List<HomeAddrForm> getHomeAddrs() {
		return homeAddrs;
	}

	public void setHomeAddrs(List<HomeAddrForm> homeAddrs) {
		this.homeAddrs = homeAddrs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getId() {
		return id;
	}
}
