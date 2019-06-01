package com.test.rest.services;

import java.util.List;

import com.test.rest.models.Cart;
import com.test.rest.models.CartProduct;
import com.test.rest.models.Product;

public interface CartService extends RestService<Cart>{

	List<CartProduct> getCartProductsByCartId(Integer cartId);
	
	Cart addProductToCart(Cart cart,  Product product,Integer quantity) ;
	
	Cart removeProductFromCart( CartProduct cartProduct) ;

}
