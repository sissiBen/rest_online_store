package com.test.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.rest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByCatalogId(Integer catalog);

}
