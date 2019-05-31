package com.test.rest.services;

import java.util.List;

import com.test.rest.models.Cart;
import com.test.rest.models.CartProduct;

public interface CartService extends RestService<Cart>{

	List<CartProduct> getCartProductsByCartId(Integer cartId);

}
