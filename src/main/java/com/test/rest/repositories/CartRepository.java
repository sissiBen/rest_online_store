package com.test.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.rest.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
