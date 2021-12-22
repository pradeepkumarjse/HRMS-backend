package com.realcoderz.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.exception.ResourceNotFoundException;
import com.realcoderz.model.Authority;
import com.realcoderz.model.User;
import com.realcoderz.repository.UserDetailsRepository;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

	private static final String imageDirectory = System.getProperty("user.dir") + "/src/main/webapp/images/user";

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public List<User> getAllUsers() {
		return userDetailsRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		User user = userDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not Found with id Value ::" + id));

		return ResponseEntity.ok().body(user);
	}
	
	
	

	@PostMapping(value = "/register", produces = { MediaType.IMAGE_PNG_VALUE, "application/json" })
	public ResponseEntity<Object> registerUser(@RequestParam("imageFile") MultipartFile file,
			@RequestParam("imageName") String imageName, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("username") String username,
			@RequestParam("password") String password) throws Exception {

		makeDirectoryIfNotExist(imageDirectory);
		Path fileNamePath = Paths.get(imageDirectory,
				imageName.concat(".").concat(FilenameUtils.getExtension(file.getOriginalFilename())));
        System.out.println(file);
		User user = new User();
		List<Authority> authorityList = new ArrayList<>();
		authorityList.add(createAuthority("User", "User role"));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPhoneNumber(phone);
		user.setCreatedAt(new Date());

		user.setProfilePicPath("http://localhost:4041/images/user/" + imageName + ".png");

		user.setUserName(username);
		user.setAuthorities(authorityList);
		user.setPassword(passwordEncoder.encode(password));
		userDetailsRepository.save(user);

		try {
			Files.write(fileNamePath, file.getBytes());
			return new ResponseEntity<>("user regsitered successfully", HttpStatus.CREATED);
		} catch (IOException ie) {
			ie.printStackTrace();
			return new ResponseEntity<>("user is not regsitered", HttpStatus.BAD_REQUEST);
		}

	}

	private void makeDirectoryIfNotExist(String imageDirectory) {
		File directory = new File(imageDirectory);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

//	@DeleteMapping("/{id}")
//	public Map<String,Boolean> deleteUserById(@PathVariable("id") Long id) throws Exception{
//		User user=userDetailsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not found with id Value : "+id));
//		userDetailsRepository.delete(user);
//		Map<String,Boolean> response =new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
	private Authority createAuthority(String roleCode, String roleDescription) {
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}