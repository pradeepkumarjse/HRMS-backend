package com.realcoderz.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Email {
	
	
	@NotNull(message = "email id should not empty")
	private String to;
	
	@NotNull
	@Size(min =2,max = 10,message = "subject should be minimum 2 charateer and max 20 chatacter" )
	private String subject;
	
	@NotNull
	@Size(min=4,max=100,message = "message have minimum 10 character")
	private String message;
	
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Email(String to, String subject, String message) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", subject=" + subject + ", message=" + message + "]";
	}
	
	

}
