package com.bleum.canton.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * base entity used for entity layer super type.
 * 
 * note: please add version property to your sub entity if you need it
 * 
 * @author stephen.huang
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@Column(name = "created_date", updatable = false)
	protected Timestamp createdDate;

	@Column(name = "last_modified_date")
	protected Timestamp lastModifiedDate;

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
