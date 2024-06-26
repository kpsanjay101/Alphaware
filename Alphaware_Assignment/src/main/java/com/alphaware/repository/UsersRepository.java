package com.alphaware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alphaware.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	Users findByEmail(String email);

}
