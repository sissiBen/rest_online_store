package com.test.rest.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.models.Product;
import com.test.rest.repositories.ProductRepository;
import com.test.rest.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<?> listAll() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getById(Integer id) {
		
		return productRepository.getOne(id);
	}

	@Override
	public Product saveOrUpdate(Product model) {
		return productRepository.save(model);
	}

	@Override
	public void delete(Integer id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> getProductsByCatalogId(Integer catalog) {
		
		return productRepository.findByCatalogId(catalog);
	}


}
