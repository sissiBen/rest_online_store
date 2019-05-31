package com.test.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.models.Cart;
import com.test.rest.models.CartProduct;
import com.test.rest.models.Product;
import com.test.rest.services.CartService;

@RestController
@RequestMapping("rest/cart")
public class CartController {
	
	private CartService cartService;
	
	@Autowired
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity addProductToCart(@RequestBody Cart cart, @RequestBody Product product,@RequestBody Integer quantity) {
		
		CartProduct cartProduct = new CartProduct();
		cartProduct.setProduct(product);
		cartProduct.setQuantity(quantity);
		cart.addCartProduct(cartProduct);
		
		cart = cartService.saveOrUpdate(cart);
		return new ResponseEntity(cart, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeproduct", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity removeProductFromCart(@RequestBody CartProduct cartProduct) {
		Cart cart = cartProduct.getCart();
		cart.removeCartProduct(cartProduct);
		cart = cartService.saveOrUpdate(cart);
		return new ResponseEntity(cart, HttpStatus.OK);
	}
	
	//web service qui affiche le contenu d'un panier 
		@RequestMapping(value = "/cartdetails/{cart}", method = RequestMethod.GET, produces = "application/json")
		public List<CartProduct> getCartProductsByCartId(@PathVariable Integer cartId ) {
			
			return cartService.getCartProductsByCartId(cartId);

		}
	

}
