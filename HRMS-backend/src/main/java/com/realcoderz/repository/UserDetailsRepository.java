package com.realcoderz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realcoderz.model.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUserName(String userName);
	
}
