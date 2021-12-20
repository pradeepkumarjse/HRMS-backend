package com.realcoderz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.helper.fileuploadhelper;
import com.realcoderz.model.Employee;
import com.realcoderz.service.employeeservice;



@RestController
@RequestMapping("/realcoder/api")
@CrossOrigin(origins = "http://localhost:3000")
public class employeecontroller {
	
	@Autowired
	private employeeservice empservice;
	
	@Autowired
	private fileuploadhelper fileupload;
	
	@GetMapping("/home")
	public String home() {
	return "index"; 
	}

	
	@GetMapping("/employees")
	public List<Employee> getemployees() {
		
		return this.empservice.getemployees();
	}

	
	//getting employee by id
	
	@GetMapping("/employees/{empid}")
	public Employee getemployee(@PathVariable String empid) {
	 
    return this.empservice.getemployee(Long.parseLong(empid));
    
	}
	
	// inserting new employee
	
    @PostMapping("/employees")
	public Employee addemployee(@RequestBody Employee emp)
	{
		System.out.print("push mapping");
    	return this.empservice.addemployee(emp);
    	
	}
    
    // update employee
    
    @PutMapping("/employees/{empid}")
    public Employee updateemployee(@PathVariable  String empid, @RequestBody Employee emp) {
    	System.out.println("employeecontroller.updateemployee()");
    	return this.empservice.updateemployee(Long.parseLong(empid),emp);
    }
    
   // delete employee
    
    @DeleteMapping("/employees/{empid}")
    public ResponseEntity<HttpStatus> deleteemployee(@PathVariable String empid) {
    	System.out.println("employeecontroller.deleteemployee()");
    	try {
    		
    		this.empservice.deleteemployee(Long.parseLong(empid));
    		
    		return new ResponseEntity<>(HttpStatus.OK);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    
   	
    }
    
    // image upload
    
    @PostMapping("/upload-file")	
	public ResponseEntity<String> uploadfile(@RequestParam("image") MultipartFile file, @RequestParam("username") String un)
    {
    	System.out.println(un);
		/*
		 * System.out.println(file.getOriginalFilename());
		 * System.out.println(file.getSize());
		 * System.out.println(file.getContentType());
		 * System.out.println(file.getName());
		 */
    	try {
    	
    	if(file.isEmpty())
    	{
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contains file");
    	}
    	
    	if(!file.getContentType().equals("image/jpeg"))
    	{
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg content type allow");	
    	}
    	
    	boolean f=fileupload.uploadfile(file);
      
    	if(f) {
    	  return ResponseEntity.ok("file is successfully uploaded");
    	  
    	}
    	
    	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!! something went wrong !!");
	}



}
