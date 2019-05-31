package com.test.rest.services;

import java.util.List;

import com.test.rest.models.Product;

public interface ProductService extends RestService<Product>{

	List<Product> getProductsByCatalogId(Integer catalog);

}
