package com.test.rest.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.models.Cart;
import com.test.rest.models.CartProduct;
import com.test.rest.repositories.CartProductRepository;
import com.test.rest.repositories.CartRepository;
import com.test.rest.services.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	private CartRepository cartRepository;
	private CartProductRepository cartProductRepository;

	@Autowired
	public void setCartRepository(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	@Autowired
	public void setCartProductRepository(CartProductRepository cartProductRepository) {
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public List<?> listAll() {
		return cartRepository.findAll();
	}

	@Override
	public Cart getById(Integer id) {
		return cartRepository.getOne(id);
	}

	@Override
	public Cart saveOrUpdate(Cart model) {
		return cartRepository.save(model);
	}

	@Override
	public void delete(Integer id) {
		cartRepository.deleteById(id);
		
	}

	@Override
	public List<CartProduct> getCartProductsByCartId(Integer cartId) {
		// TODO Auto-generated method stub
		return cartProductRepository.findByCartId(cartId);
	}

}
