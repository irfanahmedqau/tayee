package com.bleum.canton.itempage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author kevin.rao
 * @since v 0.1.0, Feb 6,2012
 * @version v 0.1.0
 */
@Entity
@Table(name = "ITEMRICHCONTENT")
public class ItemRichContent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "IRCNAME", nullable = false)
	private String IRCName;

	@ManyToOne
	@JoinColumn(name = "CATEGORY", nullable = false)
	private Category category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIRCName() {
		return IRCName;
	}

	public void setIRCName(String iRCName) {
		IRCName = iRCName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
