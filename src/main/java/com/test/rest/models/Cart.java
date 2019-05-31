package com.test.rest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart extends SuperModel{
	
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,  orphanRemoval = true)
	private List<CartProduct> cartProducts;
    
    @OneToOne(mappedBy="cart")
    private User user;
    
    
	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void addCartProduct(CartProduct cartProduct){
		cartProduct.setCart(this);
		cartProducts.add(cartProduct);
    }

    public void removeCartProduct(CartProduct cartProduct){
    	cartProduct.setCart(null);
    	cartProducts.remove(cartProduct);
    }
	
    
    

}
