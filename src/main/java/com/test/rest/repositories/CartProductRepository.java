package com.test.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.rest.models.CartProduct;
import com.test.rest.models.CartProductKey;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProductKey>{

	List<CartProduct> findByCartId(Integer cartId);

}
