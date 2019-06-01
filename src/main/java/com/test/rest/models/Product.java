package com.test.rest.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product extends SuperModel{
	
	
	private String designation;
	
	private String description;
	
	private double price;
	
	private String imageUrl;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product" )
	List<CartProduct> cartProducts;
	
	@ManyToOne
	private Catalog catalog;
	
	public Product(){
		
	}
	public Product(String designation, String description, double price, String imageUrl){
		this.designation = designation;
		
		this.description = description;
		
		this.price = price;
		
		this.imageUrl = imageUrl;
//		
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	
	

}
