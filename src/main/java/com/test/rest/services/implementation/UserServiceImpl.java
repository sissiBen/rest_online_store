package com.test.rest.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.models.Catalog;
import com.test.rest.models.User;
import com.test.rest.repositories.UserRepository;
import com.test.rest.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public List<?> listAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Integer id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional!=null){
			return optional.get();
		}
		return null;
	}

	@Override
	public User saveOrUpdate(User model) {
		return userRepository.save(model);
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
		
	}

}
