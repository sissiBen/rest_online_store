package com.test.rest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CartProductKey implements Serializable{
	
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cart", insertable=false, updatable=false)
	private Integer cart;

	@Column(name="product", insertable=false, updatable=false)
	private Integer product;

	@Column(insertable=false, updatable=false)
	private Integer internal;

	public CartProductKey() {
	}

	public Integer getCart() {
		return cart;
	}

	public void setCart(Integer cart) {
		this.cart = cart;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public Integer getInternal() {
		return internal;
	}

	public void setInternal(Integer internal) {
		this.internal = internal;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CartProductKey)) {
			return false;
		}
		CartProductKey castOther = (CartProductKey)other;
		return 
			this.cart.equals(castOther.cart)
			&& this.product.equals(castOther.product);
			
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cart.hashCode();
		hash = hash * prime + this.product.hashCode();
		
		
		return hash;
	}
}
