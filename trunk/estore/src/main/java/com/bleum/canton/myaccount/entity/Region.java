package com.bleum.canton.myaccount.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author lynn.chen
 * @since v 0.1.0 ,Feb 6, 2012
 * @version v 0.1.0
 */
@Entity
@Table(name="MYACC_REGION")
public class Region extends BaseEntity implements  Serializable {

	private static final long serialVersionUID = -6634112408356760149L;

	@Id
	@GeneratedValue(generator="")
	private Long id;
	
	@OneToOne(optional=false)
	@JoinColumn(name="PARENTID",nullable=false)
	private Region parentRegion;
	
	@Column(name="REGIONNAME")
	private String regionName;
	
	@Column(name="REGIONTYPE")
	private Long regionType;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public Region getParentRegion() {
		return parentRegion;
	}

	public void setParentRegion(Region parentRegion) {
		this.parentRegion = parentRegion;
	}

	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName
	 *            the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return the regionType
	 */
	public Long getRegionType() {
		return regionType;
	}

	/**
	 * @param regionType
	 *            the regionType to set
	 */
	public void setRegionType(Long regionType) {
		this.regionType = regionType;
	}

}
