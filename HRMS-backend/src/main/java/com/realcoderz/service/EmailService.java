package com.realcoderz.service;

import com.realcoderz.model.Email;

public interface EmailService {
	
	public boolean sendemail(String subject,String message,String to);

}
