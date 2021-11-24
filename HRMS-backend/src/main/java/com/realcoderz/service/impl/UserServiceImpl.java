package com.realcoderz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.model.User;
import com.realcoderz.repository.IUserRepo;
import com.realcoderz.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {
   
	@Autowired
	private IUserRepo userRepo;
	
	@Override
	public void save(User user) {
		userRepo.save(user);		
	}

	
}
