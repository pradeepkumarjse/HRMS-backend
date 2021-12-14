package com.realcoderz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.realcoderz.model.Authority;
import com.realcoderz.model.User;
import com.realcoderz.repository.UserDetailsRepository;

@SpringBootApplication
public class HumanResourceManagementSystemApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HumanResourceManagementSystemApplication.class, args);
	}
}
	
//	@PostConstruct
//	protected void init() {
//		
//	List<Authority> authorityList=new ArrayList<>();
//	
//		authorityList.add(createAuthority("USER","User role"));
//		//authorityList.add(createAuthority("ADMIN","Admin role"));
//		

//	User user=new User();
//	
//		user.setUserName("puskar");
//		user.setFirstName("Abhiraj");
//		user.setLastName("Puskar");
//	
//		user.setPassword(passwordEncoder.encode("puskar@123"));
//		user.setEnabled(true);
//		user.setAuthorities(authorityList);
//		
//		userDetailsRepository.save(user);		

//		User user=new User();
//		
//		user.setUserName("user");
//		user.setFirstName("User");
//		user.setLastName("Role");
//		
//		user.setPassword(passwordEncoder.encode("user@123"));
//		user.setEnabled(true);
//		user.setAuthorities(authorityList);		
//		userDetailsRepository.save(user);
//		
//	}
//	
//	
//	private Authority createAuthority(String roleCode,String roleDescription) {
//		Authority authority=new Authority();
//		authority.setRoleCode(roleCode);
//		authority.setRoleDescription(roleDescription);
//		return authority;
//	}

//	
//
//}

