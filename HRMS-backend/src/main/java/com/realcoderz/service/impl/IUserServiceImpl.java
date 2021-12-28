package com.realcoderz.service.impl;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.realcoderz.repository.UserDetailsRepository;
import com.realcoderz.service.IUserService;

@Service("userService")
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Optional<com.realcoderz.model.User> opt=userDetailsRepository.findByUserName(username);

		 if(opt.isEmpty())
	    	    throw  new   IllegalArgumentException("user not found ");
		 else {
			 com.realcoderz.model.User user=opt.get();
			 
			 //User user=new User(details.getFirstName(), details.getPassword(), details.getAuthorities().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			 
		 return  user;
		 
		
			
		 }
		
	}


	

	

}
