package com.bleum.canton.myaccount.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;
import com.bleum.canton.myaccount.enumeration.RegionType;

/**
 * @author lynn.chen
 * @since v 0.1.0 ,Feb 6, 2012
 * @version v 0.1.0
 */
@Entity
@Table(name="MYACC_REGION")
@NamedQueries({
	@NamedQuery(name="Region.findByParentId",query="FROM Region r WHERE r.parentRegion=:parentRegion"),
	@NamedQuery(name="Region.findByRegionType",query="FROM Region r WHERE r.regionType=:regionType")
	
	
	
})
 




public class Region extends BaseEntity {

	private static final long serialVersionUID = -6634112408356760149L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "seq_region", sequenceName = "SEQ_MYACC_REGION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_region")
	private Long id;

	@OneToOne(optional = true)
	@JoinColumn(name = "PARENT")
	private Region parentRegion;

	@Column(name = "REGIONNAME")
	private String regionName;

	@Column(name = "REGIONTYPE")
	@Enumerated(value = EnumType.ORDINAL)
	private RegionType regionType;

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
	public RegionType getRegionType() {
		return regionType;
	}

	/**
	 * @param regionType
	 *            the regionType to set
	 */
	public void setRegionType(RegionType regionType) {
		this.regionType = regionType;
	}

}
