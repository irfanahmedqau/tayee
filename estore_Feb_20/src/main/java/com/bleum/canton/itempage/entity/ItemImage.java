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
@Table(name="CATA_ITEMIMAGE")
public class ItemImage extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_CATA_ITEMIMAGE")
	@SequenceGenerator(name = "SEQ_CATA_ITEMIMAGE",sequenceName="SEQ_CATA_ITEMIMAGE")
	private int id;
	
	@Column(name="TYPE",nullable=false)
	private String type;
	
	@Column(name="URL",nullable=false)
	private String url;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID",nullable=false)
	private Item item;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	
	
}
