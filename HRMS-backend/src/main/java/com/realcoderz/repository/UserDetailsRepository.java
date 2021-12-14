package com.realcoderz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realcoderz.model.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
	
}
