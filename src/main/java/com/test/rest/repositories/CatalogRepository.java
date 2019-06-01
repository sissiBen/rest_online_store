package com.test.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.rest.models.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Integer>{

}
