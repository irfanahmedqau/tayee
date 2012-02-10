package com.bleum.canton.myaccount.command;

import javax.validation.constraints.NotNull;

/**
 * @author lynn.chen
 * @since v 0.1.0 ,Feb 6, 2012
 * @version v 0.1.0
 */
public class RegionForm {

	@NotNull
	private Long id;
	
	@NotNull
	private RegionForm parentRegion;
	
	@NotNull
	private String regionName;
	
	@NotNull
	private Long regionType;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public RegionForm getParentRegion() {
		return parentRegion;
	}

	public void setParentRegion(RegionForm parentRegion) {
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
