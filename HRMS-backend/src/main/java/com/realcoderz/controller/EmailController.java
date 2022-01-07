package com.realcoderz.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.model.Email;
import com.realcoderz.service.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {
	
	private static final Logger logger=LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private EmailService emailservice;
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendemail(@Valid @RequestBody Email email) 
	{
		logger.debug("sendmail() called from EmailController");
	 boolean response=this.emailservice.sendemail(email.getSubject(),email.getMessage(),email.getTo());
	 
	 if(response) 
	 {
		 logger.info("email send successfully");
		 return ResponseEntity.ok("sendig mail successfull..");
	 }
	 else 
	 {
		 logger.info("email not send");
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email not send");
	 }
		
		
	}
}
