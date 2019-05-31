package com.test.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.rest.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
