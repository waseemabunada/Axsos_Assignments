package com.example.axsos.repositories;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.example.axsos.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
	
}
