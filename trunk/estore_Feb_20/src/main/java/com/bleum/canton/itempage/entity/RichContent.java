package com.bleum.canton.itempage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "CATA_RC")
public class RichContent extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CATA_RC")
	@SequenceGenerator(name = "SEQ_CATA_RC", sequenceName = "SEQ_CATA_RC")
	private int id;
	@Column(name = "RC_NAME", nullable = false)
	private String RCName;
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category rc_category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRCName() {
		return RCName;
	}

	public void setRCName(String rCName) {
		RCName = rCName;
	}

	public Category getRc_category() {
		return rc_category;
	}

	public void setRc_category(Category rc_category) {
		this.rc_category = rc_category;
	}

}
