package com.realcoderz.service;

import java.util.List;

import com.realcoderz.model.Admin;

public interface adminservice {
	
public List<Admin> getadmin();
	
	public Admin getadmin(Long empid);
	
	public Admin addadmin(Admin emp);
	
	public Admin updateadmin(Long empid,Admin emp);
	
	public Admin deleteadmin(Long empid);

}