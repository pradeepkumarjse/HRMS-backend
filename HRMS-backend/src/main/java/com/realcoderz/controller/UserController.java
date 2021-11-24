 package com.realcoderz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.model.User;
import com.realcoderz.repository.IUserRepo;
import com.realcoderz.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserRepo userRepo;
	
	@GetMapping("/find")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		userService.save(user);		
		return new ResponseEntity<>("user inserted successfully",HttpStatus.OK);
		
	}

}
