package com.bleum.canton.shoppingcart.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;



/**
 * @author leon.liu
 * @since 
 * @version 
 */
@Entity
@Table(name = "CART")
public class Cart extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5432653963360013349L;
	
    @Id
    @Column(name = "ID")
	private Long id;
	
    @Column(name = "DATE", nullable = false)
	private Date createDate;
	
	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
	@Column(name = "STATE", nullable = false)
	private CartState state = CartState.TRANSIENT;
	
	@OneToMany
	private List<CartItem> cartItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CartState getState() {
		return state;
	}

	public void setState(CartState state) {
		this.state = state;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	

}
