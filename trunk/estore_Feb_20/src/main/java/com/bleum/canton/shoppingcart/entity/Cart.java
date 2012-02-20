package com.bleum.canton.shoppingcart.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bleum.canton.common.entity.BaseEntity;
import com.bleum.canton.myaccount.entity.Customer;
import com.bleum.canton.shoppingcart.enumeration.CartStatus;



/**
 * @author leon.liu
 * @since 
 * @version 
 */
@Entity
@Table(name = "SC_SHOPPING_CART")
public class Cart extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5432653963360013349L;
	
    @Id
    @Column(name = "ID")
	private Long id;
	
	@Column(name = "STATUS", nullable = false)
	@Enumerated(value=EnumType.ORDINAL)
	private CartStatus status = CartStatus.TRANSIENT;
	
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	@OneToOne
	@JoinColumn(name = "CART_OWNER_NAME", referencedColumnName = "loginName",nullable = false)
	private Customer customer;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
