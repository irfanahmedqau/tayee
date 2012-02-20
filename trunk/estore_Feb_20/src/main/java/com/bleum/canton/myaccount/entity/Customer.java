package com.bleum.canton.myaccount.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;
import com.bleum.canton.myaccount.enumeration.CustomerStatus;

/**
 * @author lynn.chen
 * @since v 0.1.0 ,Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name="MYACC_CUSTOMER")
@NamedQueries({
	@NamedQuery(name="Customer.findById",query="from Customer c where c.id = :id"),
	@NamedQuery(name="Customer.findByLoginName",query="from Customer c where c.loginName = :loginName"),
	@NamedQuery(name="Customer.findByEmail",query="from Customer c where c.email = :email")
})
public class Customer extends BaseEntity {

	private static final long serialVersionUID = -7876950330543287014L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "seq_customer", sequenceName = "SEQ_MYACC_CUSTOMER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customer")
	private Long id;

	@Column(name = "LOGINNAME", nullable = false)
	private String loginName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private CustomerProfile profile;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HomeAddr> homeAddrs;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LASTLOGINDATE")
	private Timestamp lastLoginDate;

	@Column(name = "STATUS")
	@Enumerated(value = EnumType.ORDINAL)
	private CustomerStatus status;

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

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	
}
