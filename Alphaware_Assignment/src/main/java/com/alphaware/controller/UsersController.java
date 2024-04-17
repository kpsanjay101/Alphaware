package com.alphaware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphaware.model.Users;
import com.alphaware.repository.UsersRepository;
import com.alphaware.service.UsersService;


@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<Users> registerUsers(@RequestBody Users users){
		
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		
		return new ResponseEntity<Users>(userService.registerUsers(users) , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> logInUserHandler(Authentication auth){
    	Users opt= usersRepository.findByEmail(auth.getName());
		 if(opt==null) throw new RuntimeException("No user found") ;
		 Users user = opt;
		 return new ResponseEntity<>(user.getUser_name()+" Logged In Successfully", HttpStatus.ACCEPTED);
	}       
	

}
