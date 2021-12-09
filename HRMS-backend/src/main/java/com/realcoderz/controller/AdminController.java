package com.realcoderz.controller;


import java.util.List;

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
	
	@Autowired
	private adminservice empservice;
	

	
	@GetMapping("/home")
	public String home() {
	return "index"; 
	}

	// get all admin details
	
	@GetMapping("/admin")
	public List<Admin> getadmin() {
		
		return this.empservice.getadmin();
	}

	
	//getting admin by id
	
	@GetMapping("/admin/{empid}")
	public Admin getadmin(@PathVariable String empid) {
	 
    return this.empservice.getadmin(Long.parseLong(empid));
    
	}
	
	// inserting new admin
	
    @PostMapping("/admin")
	public Admin addadmin(@RequestBody Admin emp)
	{
		System.out.print("push mapping");
    	return this.empservice.addadmin(emp);
    	
    	
	}
    
    
    // update employee
    
    @PutMapping("/employees/{empid}")
    public Admin updateadmin(@PathVariable  String empid, @RequestBody Admin emp) {
    	System.out.println("employeecontroller.updateemployee()");
    	return this.empservice.updateadmin(Long.parseLong(empid),emp);
    }
    
    	
    	 // delete employee
        
        @DeleteMapping("/admin/{empid}")
        public Admin deleteemployee(@PathVariable String empid) {
        	System.out.println("employeecontroller.deleteemployee()");
        	
           return this.empservice.deleteadmin(Long.parseLong(empid));
        }
        	
    
 
    
    

}