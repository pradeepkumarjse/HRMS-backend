package com.realcoderz.service;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.realcoderz.model.User;
import com.realcoderz.repository.UserDetailsRepository;

@Service
public class CustomUserService implements UserDetailsService{

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<com.realcoderz.model.User> opt =userDetailsRepository.findByUserName(username);
		
		if(opt.isEmpty()) {
			throw new UsernameNotFoundException("user not found with userName : "+username);
		}
		else {
			com.realcoderz.model.User details=opt.get();
			
			//User user=new User(details.getUsername(),details.getPassword(),details.getAuthorities().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			
			return details;
		}
		
		
		
		
		
	}

}