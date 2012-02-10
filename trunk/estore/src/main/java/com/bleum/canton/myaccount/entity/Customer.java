package com.bleum.canton.myaccount.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author lynn.chen
 * @since v 0.1.0 ,Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name="MYACC_CUSTOMER")
public class Customer extends BaseEntity  implements Serializable {

	private static final long serialVersionUID = -7876950330543287014L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@Column(name="LOGINNAME",nullable=false)
	private String loginName;

	@Column(name="PASSWORD",nullable=false)
	private String password;

	@OneToOne(optional=false)
	@JoinColumn(name="PROFILE",nullable=false)
	private CustomerProfile profile;

	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="HOMEADDRESSES",nullable=false)
	private List<HomeAddr> homeAddrs;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="LASTLOGINDATE")
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

	public CustomerProfile getProfile() {
		return profile;
	}

	public void setProfile(CustomerProfile profile) {
		this.profile = profile;
	}

	public List<HomeAddr> getHomeAddrs() {
		return homeAddrs;
	}

	public void setHomeAddrs(List<HomeAddr> homeAddrs) {
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
