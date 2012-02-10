package com.bleum.canton.shoppingcart.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;
import com.bleum.canton.itempage.entity.Item;

@Entity
@Table(name="CART_ITEM")
public class CartItem extends BaseEntity implements Serializable{


	private static final long serialVersionUID = -7795828802344884437L;
    
    @Id
    @Column(name = "ID")
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "CART", nullable = false)
	private Cart cart;
	
	@Column(name = "QUANTITY", nullable = false)
	private Integer quantity;
	
	@Column(name = "STATE", nullable = false)
	private CartItemState state = CartItemState.NORMAL;
	
	@Column(name = "ITEM_ID", nullable = false)
	private Long itemID;
	
	@Column(name = "ITEM_NAME", nullable = false)
	private String itemName;
	
	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
	@OneToOne
	@JoinColumn(name = "ITEM", nullable = false)
	private Item item;

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

	public CartItemState getState() {
		return state;
	}

	public void setState(CartItemState state) {
		this.state = state;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
