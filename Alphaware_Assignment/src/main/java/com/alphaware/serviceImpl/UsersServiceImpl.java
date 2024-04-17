package com.alphaware.serviceImpl;

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

}
