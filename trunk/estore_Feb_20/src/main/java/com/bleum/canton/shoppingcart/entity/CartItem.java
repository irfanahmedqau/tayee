package com.bleum.canton.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.bleum.canton.common.entity.BaseEntity;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.shoppingcart.enumeration.CartItemStatus;

@Entity
@Table(name="SC_SHOPPING_CART_ITEM")
public class CartItem extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7795828802344884437L;
    
    @Id
    @Column(name = "ID")
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "CART_ID", nullable = false)
	private Cart cart;
	
	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity = 0;
	
	@Column(name = "ITEM_ID_INFO", nullable = false)
	private Integer itemId;
	
	@Column(name = "ITEM_NAME_INFO", nullable = false)
	private String itemName;

	@Transient
	@OneToOne
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;


	@Column(name = "CARTITEM_STATUS")
	@Enumerated(EnumType.ORDINAL)
	private CartItemStatus status = CartItemStatus.NORMAL;
	
	public CartItem(){
		
	}
	
	public CartItem(Item item, Integer quantity, Cart cart) {
		super();
		this.cart = cart;
		this.quantity = quantity;
		this.item = item;
		this.itemId = item.getId();
		this.itemName = item.getItemName();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public CartItemStatus getStatus() {
		return status;
	}

	public void setStatus(CartItemStatus status) {
		this.status = status;
	}
	
}
