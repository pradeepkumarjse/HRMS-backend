package com.realcoderz.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.helper.adminfilehelper;
import com.realcoderz.model.Admin;
import com.realcoderz.repository.AdminRepository;
import com.realcoderz.service.adminservice;
import com.realcoderz.service.impl.adminserviceimpl;

@Service
public  class adminserviceimpl implements adminservice {
	
	

	@Autowired
	private  adminfilehelper adminfilehelper;

	@Autowired
	private AdminRepository adminrepository;



	// get all admin
	@Override
	public List<Admin> getadmin() {
	// TODO Auto-generated method stub
	return adminrepository.findAll();
	}


	//get admin by id
	@Override
	public Admin getadmin(Long adminid) {
	Optional<Admin>	admin= adminrepository.findById(adminid);
	if(admin.isPresent())
	{
		return admin.get();
	}
		return null;
	}
	



	// insert admin
	@Override
	public String addadmin(Admin admin,MultipartFile file) {
		// TODO Auto-generated method stub
		
		
			boolean f=adminfilehelper.uploadFile1(admin,file);
			return "uploaded" ;
		
		
	
	}


	//update admin
	@Override
	public Admin updateadmin(Long adminid,Admin admin) {
		Optional<Admin>	admin1= adminrepository.findById(adminid);
		if(admin1.isPresent())
		{
			adminrepository.save(admin);
		}
		return admin;
	}

	
	// delete admin
	@Override
	public Admin deleteadmin(Long adminid) {
		adminrepository.deleteById(adminid);
		return null;
	}
}