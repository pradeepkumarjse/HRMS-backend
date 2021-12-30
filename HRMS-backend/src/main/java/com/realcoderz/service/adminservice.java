package com.realcoderz.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.model.Admin;


public interface adminservice {
	
public List<Admin> getadmin();
	
	public Admin getadmin(Long adminid);
	
	public String addadmin(Admin admin,MultipartFile file);
	
	public Admin updateadmin(Long admid,Admin admin);
	
	public Admin deleteadmin(Long adminid);



}