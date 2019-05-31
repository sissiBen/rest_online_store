package com.test.rest.services;

import java.util.List;

public interface RestService<T> {
	
	List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T model);

    void delete(Integer id);


}
