package com.alphaware.service;

import java.util.List;

import com.alphaware.model.Users;

public interface UsersService {
	
	public Users registerUsers(Users users);
	
	public List<Users> getAllUsers();
	
	public Users getsersByEmail(String email);
	
	
	

}
