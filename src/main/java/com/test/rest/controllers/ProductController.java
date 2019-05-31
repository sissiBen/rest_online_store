package com.test.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.models.Product;
import com.test.rest.services.ProductService;


@RestController
@RequestMapping("rest/product")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
	//web service qui affiche les produits d'un catalogue 
	@RequestMapping(value = "/productsbycatalog/{catalog}", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getProductsByCatalogId(@PathVariable Integer catalogId ) {
		
		return productService.getProductsByCatalogId(catalogId);

	}
	
	//web service qui affiche le détails d'un seul produit
	@RequestMapping(value = "/productsbyid/{product}", method = RequestMethod.GET, produces = "application/json")
	public Product getProductById(@PathVariable Integer productId ) {
			
		return productService.getById(productId);

	}
		
	

}
