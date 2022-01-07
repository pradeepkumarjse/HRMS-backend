package com.realcoderz.service.impl;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.realcoderz.model.Email;
import com.realcoderz.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	private static final Logger logger=LoggerFactory.getLogger(EmailServiceImpl.class);

	@Override
	public boolean sendemail(String subject,String message,String to) {
		
		logger.debug("sendemail() called from EmailServiceImpl");
		boolean	f=false;
		
		String from="mk121mohit@gmail.com";
		
		// variable for gmail
		
		String host="smtp.gmail.com.";
		
		//get the system properties
		Properties properties=System.getProperties();
		
		//setting the host
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth", "true");
		
		//step1 : to get the session object
		
			Session session=Session.getInstance(properties, new Authenticator() 
		{

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("mk121mohit@gmail.com","mohitsharmamk");
			}
			
		});
		
		
			// debuge code to console
			session.setDebug(true);
		
			
			
			// step 2 : compose the text
			
			MimeMessage m=new MimeMessage(session);
			
			// from email
			try {
				
				m.setFrom(from);
				
			// to email
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
			// adding subject
				
				m.setSubject(subject);
				
			// adding text message only
				
//				m.setText(message);
			
				// code for attaching file and text both
				
				String path="C:\\Users\\mohit\\Desktop\\companylogo.png";
				
				MimeMultipart mimemultipart=new MimeMultipart();
				
				MimeBodyPart textmime=new MimeBodyPart();
				MimeBodyPart filemime=new MimeBodyPart();
				
				try {
					
					textmime.setText(message);
					File file=new File(path);
					
					filemime.attachFile(file);
					
					mimemultipart.addBodyPart(filemime);
					mimemultipart.addBodyPart(textmime);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				m.setContent(mimemultipart);
			
				
				// step 3: sending message	
				
				
				Transport.send(m);
				
				f=true;
				
				logger.info("email send successfully");
				
				
			}
			catch (Exception e) {
				logger.info("Error in EmailServiceImpl class");
				e.printStackTrace();
			}
			
			return f;
	}

}
