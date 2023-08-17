package com.realcoderz.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.model.Admin;
import com.realcoderz.service.adminservice;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class AdminController {
	
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private adminservice empservice;
	

	// get all admin details
	
	@GetMapping("/admin")
	public List<Admin> getadmin() {
		
		logger.debug("getadmin() called from AdminController");
		
		return this.empservice.getadmin();
	}

	
	//getting admin by id
	
	@GetMapping("/admin/{empid}")
	public Admin getadmin(@PathVariable String empid) {
		
		logger.debug("getadmin() called from AdminController");
	 
    return this.empservice.getadmin(Long.parseLong(empid));
    
	}
	
	// inserting new admin
	
    @PostMapping("/admin")
	public Admin addadmin(@Valid @RequestBody Admin emp)
	{
    	logger.info("addadmin() called from AdminController");
		return this.empservice.addadmin(emp);
    	
    	
	}
    
    
    // update employee
    
    @PutMapping("/employees/{empid}")
    public Admin updateadmin(@PathVariable  String empid, @RequestBody Admin emp) {
    	
    	logger.debug("updateadmin() called from AdminController");
    	
    	return this.empservice.updateadmin(Long.parseLong(empid),emp);
    }
    
    	
    	 // delete employee
        
        @DeleteMapping("/admin/{empid}")
        public Admin deleteemployee(@PathVariable String empid) {
        	logger.debug("deleteemployee() called from AdminController");
        	return this.empservice.deleteadmin(Long.parseLong(empid));
        }
        	
    
 
    
    

}