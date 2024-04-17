package com.alphaware.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaware.exceptions.UsersException;
import com.alphaware.model.Users;
import com.alphaware.repository.UsersRepository;
import com.alphaware.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository userRepo;
	

	@Override
	public Users registerUsers(Users users) {
		
		Optional<Users> opUsers = userRepo.findById(users.getId());
		
		if(!opUsers.isPresent()) {
			return userRepo.save(users);
		}
		else {
			throw new UsersException("User already register with this id "+users.getId());
		}

	}


	@Override
	public List<Users> getAllUsers() {
		List<Users> userList = userRepo.findAll();
		
		if(!userList.isEmpty()) {
			return userList;
		}else {
			throw new UsersException("No Users exist at this moment");
		}

	}


	@Override
	public Users getsersByEmail(String email) {
		
		Users user = userRepo.findByEmail(email);
		
		if(user != null) {
			return user;
		}
		else {
			throw new UsersException("User doesn't exist with this email "+email);
		}
		
	}

}
