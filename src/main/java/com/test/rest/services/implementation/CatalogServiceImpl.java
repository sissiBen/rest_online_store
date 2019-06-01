package com.test.rest.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.models.Catalog;
import com.test.rest.repositories.CatalogRepository;
import com.test.rest.services.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

	private CatalogRepository catalogRepository;
	
	@Autowired
	public void setCatalogRepository(CatalogRepository catalogRepository) {
		this.catalogRepository = catalogRepository;
	}

	@Override
	public List<?> listAll() {
		return catalogRepository.findAll();
	}

	@Override
	public Catalog getById(Integer id) {
		return catalogRepository.getOne(id);
	}

	@Override
	public Catalog saveOrUpdate(Catalog model) {
		return catalogRepository.save(model);
	}

	@Override
	public void delete(Integer id) {
		catalogRepository.deleteById(id);
		
	}

}
