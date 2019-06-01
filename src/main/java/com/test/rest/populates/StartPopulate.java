package com.test.rest.populates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.test.rest.models.Cart;
import com.test.rest.models.Catalog;
import com.test.rest.models.Product;
import com.test.rest.models.User;
import com.test.rest.services.CartService;
import com.test.rest.services.CatalogService;
import com.test.rest.services.ProductService;
import com.test.rest.services.UserService;

@Component
public class StartPopulate implements ApplicationListener<ContextRefreshedEvent>{
	
	private ProductService productService;
	private CartService cartService;
	private CatalogService catalogService;
	private UserService userService;
	
	private Catalog catalog;
	private Product product1;
	private Product product2;
	private Product product3;
	
	private Cart cart;
	private User user;
	
    @Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
    
    @Autowired
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
    
    @Autowired
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
    
    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		createCatalog();
		createProducts();
		createCart();
		createUser();
		
		
	}

	private void createCatalog() {
		
		//Création d'un catalogue
		catalog = new Catalog();
		catalog.setDesignation("My test Catalog");
		catalog = catalogService.saveOrUpdate(catalog);
		
	}

	private void createProducts() {
		
		//Création de 3 produits et les mettre dans le catalogue "My test Catalog"
		
		product1 = new Product("produit1", "Une description pour le produit 1", 20.0, "");
		product1.setCatalog(catalog);
		product1 = productService.saveOrUpdate(product1);
		
		product2 = new Product("product2", "Une description pour le produit 2", 30.0, "");
		product2.setCatalog(catalog);
		product2 = productService.saveOrUpdate(product2);
		
		product3 = new Product("product3", "Une description pour le produit 3", 50.0, "");
		product3.setCatalog(catalog);
		product3 = productService.saveOrUpdate(product3);
		
	}
	

	private void createCart() {
		//créer un panier
		cart =  new Cart();
		cart= cartService.saveOrUpdate(cart);
		
		//ajouter 2 produits dans le panier
		cart = cartService.addProductToCart(cart, product1, 1);
		cart = cartService.addProductToCart(cart, product2, 4);
		
	}
	
	private void createUser() {
		// crééer un user test 
		user = new User();
		user.setUserName("test");
		user.setPassWord("Test.2019");
		user.setEnabled(true);
		
		//affecter un panier au user test
		user.setCart(cart);
		user = userService.saveOrUpdate(user);
		
	}

	

}
