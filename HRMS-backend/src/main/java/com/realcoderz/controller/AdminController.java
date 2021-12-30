package com.realcoderz.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.helper.adminfilehelper;
import com.realcoderz.model.Admin;
import com.realcoderz.service.adminservice;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class AdminController {

	@Autowired
     adminservice adminservice;

	@Autowired
	private  adminfilehelper adminfilehelper;


	@GetMapping("/home")
	public String home() {
		return "index"; 
	}


	// get all admin details
	@GetMapping("/admin")
	public List<Admin> getadmin() {
		return this.adminservice.getadmin();
	}

	//getting admin by id
	@GetMapping("/admin/{adminid}")
	public Admin getadmin(@PathVariable String adminid) {
		return this.adminservice.getadmin(Long.parseLong(adminid));
	}

	
	
////  inserting new admin
	@PostMapping("/admin")
	public String addadmin(@RequestPart("admin") Admin admin, @RequestPart("file") MultipartFile file)
	{
		System.out.print("push mapping");
//		System.out.print(admin);
    	System.out.print(file);
		
		return this.adminservice.addadmin(admin ,file);
	}
	
	
	
	// update admin 
	@PutMapping("/admin/{adminid}")
	public Admin updateadmin(@PathVariable  String adminid, @RequestBody Admin admin) {
		System.out.println("admincontroller.updateadmin()");
		return this.adminservice.updateadmin(Long.parseLong(adminid),admin);
	}


	
////       delete admin 
	    @DeleteMapping("/admin/{adminid}")
	          public ResponseEntity<HttpStatus> deleteadmin(@PathVariable String adminid) {
		       System.out.println("admincontroller.deleteadmin()");
		try {
			this.adminservice.deleteadmin(Long.parseLong(adminid));
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    }
}
	 























//.......................................admin crud part..................................



//// inserting new admin
//@PostMapping("/admin")
//public Admin addadmin(@RequestBody Admin adm){
//	System.out.print("push mapping");
//	return this.adminservice.addadmin(adm);
//}
//
////// update employee
//@PutMapping("/admin/{admid}")
//public Admin updateadmin(@PathVariable  String admid, @RequestBody Admin adm) {
//	System.out.println("admincontroller.updateadmin()");
//	return this.adminservice.updateadmin(Long.parseLong(admid),adm);
//}
//
//// delete employee
//@DeleteMapping("/admin/{admid}")
//public Admin deleteadmin(@PathVariable String admid) {
//	System.out.println("admincontroller.deleteadmin()");
//	return this.adminservice.deleteadmin(Long.parseLong(admid));
//}
//}

