package com.realcoderz.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.model.Admin;
import com.realcoderz.repository.AdminRepository;
import com.realcoderz.service.adminservice;




@Service
public class adminserviceimpl implements adminservice {

	
	

	@Autowired
	private AdminRepository emprepository;
	
	// get all admin
	
	@Override
	public List<Admin> getadmin() {
		// TODO Auto-generated method stub
		return emprepository.findAll();
	}


	//get admin by id
	
	@Override
	public Admin getadmin(Long empid) {
		
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
		// TODO Auto-generated method stub

		emprepository.save(emp);
		
		return emp;
	}

	//update admin
	
	@Override
	public Admin updateadmin(Long empid,Admin emp) {
		
		Optional<Admin>	empp= emprepository.findById(empid);
		
		if(empp.isPresent())
		{
			emprepository.save(emp);

		}
		 
		return emp;
		
	}

	
	// delete admin

	@Override
	public Admin deleteadmin(Long empid) {
		
		emprepository.deleteById(empid);
		
		return null;
	}

}