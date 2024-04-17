package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Users;

public interface UsersService {
	
	Users registerUsers(Users users);
	
	List<Users> getAllUsers();
	
	Users getsersByEmail(String email);
	
	
	

}
