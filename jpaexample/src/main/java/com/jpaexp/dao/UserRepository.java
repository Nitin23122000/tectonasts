package com.jpaexp.dao;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.CrudRepository;

import com.jpaexp.entity.user;

public interface UserRepository extends CrudRepository<user, Integer>{

	

	
}
