package com.realcoderz.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.model.Admin;
import com.realcoderz.repository.AdminRepository;
import com.realcoderz.service.adminservice;

@Service
public class adminserviceimpl implements adminservice {

	private static final Logger logger=LoggerFactory.getLogger(adminserviceimpl.class);
	
	@Autowired
	private AdminRepository emprepository;
	
	// get all admin
	
	@Override
	public List<Admin> getadmin() {
		
		logger.debug("getadmin() called from adminserviceimpl class");
		
		// TODO Auto-generated method stub
		return emprepository.findAll();
	}


	//get admin by id
	
	@Override
	public Admin getadmin(Long empid) {
		
	logger.debug("getadmin() called from adminserviceimpl class");
	Optional<Admin>	emp= emprepository.findById(empid);
		
	if(emp.isPresent())
	{
		return emp.get();

	}
	return null;
	}
	
	// insert admin
	
	@Override
	public Admin addadmin(Admin emp) {
		
		logger.debug("addadmin() called from adminserviceimpl class");
		
	emprepository.save(emp);
		logger.info("Record save of Admin");
		return emp;
	}

	//update admin
	
	@Override
	public Admin updateadmin(Long empid,Admin emp) {
		
		logger.debug("updateadmin() called from adminserviceimpl class");
		
		Optional<Admin>	empp= emprepository.findById(empid);
		
		if(empp.isPresent())
		{
			emprepository.save(emp);
			logger.info("Record Updated");

		}
		 
		return emp;
		
	}

	// delete admin

	@Override
	public Admin deleteadmin(Long empid) {
		
		logger.debug("deleteadmin() called from adminserviceimpl class");
		emprepository.deleteById(empid);
		logger.info("Record Deleted");
		return null;
	}

}