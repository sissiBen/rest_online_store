package com.test.rest.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartProduct {
	
	@EmbeddedId
	private CartProductKey id;
	
	@ManyToOne()
	@JoinColumn(name="cart", insertable = false, updatable = false)
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="product", insertable = false, updatable = false)
	private Product product;
	
	private int quantity;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
