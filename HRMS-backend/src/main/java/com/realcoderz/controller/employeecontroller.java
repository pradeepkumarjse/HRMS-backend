package com.realcoderz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;


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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.helper.fileuploadhelper;
import com.realcoderz.model.Employee;
import com.realcoderz.service.employeeservice;

@RestController
@RequestMapping("/realcoder/api")
@CrossOrigin(origins = "http://localhost:3000")
public class employeecontroller {
	
	private static final Logger logger= LoggerFactory.getLogger(employeecontroller.class);
	
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
		
		logger.info("getemployees() called to get all employees from employeecontroller");
		return this.empservice.getemployees();
	}

	
	//getting employee by id
	
	@GetMapping("/employees/{empid}")
	public Employee getemployee(@PathVariable String empid) {
		
		logger.info("getemployees() called to  employee by id from  employeecontroller");
	 
    return this.empservice.getemployee(Long.parseLong(empid));
    
	}
	
	// inserting new employee
	
	
    @PostMapping("/employees")
	public String addemployee(@Valid @RequestPart("emp") Employee emp, @Valid @RequestPart("file") MultipartFile file)
	{
		logger.info("addemployee() called to add employees from  employeecontroller");
    	return this.empservice.addemployee(emp,file);
    	
	}
    
    
    
    
    
    // update employee
    
    @PutMapping("/employees/{empid}")
    public Employee updateemployee(@Valid @PathVariable  String empid,@Valid @RequestBody Employee emp) {
    	
    	logger.info("updateemployee() called from  employeecontroller");

    	System.out.println("employeecontroller.updateemployee()");

    	return this.empservice.updateemployee(Long.parseLong(empid),emp);
    }
    
   // delete employee
    
    @DeleteMapping("/employees/{empid}")
    public ResponseEntity<HttpStatus> deleteemployee(@PathVariable String empid) {
    	logger.info("deleteemployee() called from employeecontroller");
    	try {
    		
    		this.empservice.deleteemployee(Long.parseLong(empid));
    		logger.info("deleted successfully");
    		return new ResponseEntity<>(HttpStatus.OK);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		logger.error("something went wrong in deleteemployee() in employeecontroller");
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    
   	
    }
    

    @PostMapping("/upload-file")	
	public ResponseEntity<String> uploadfile(@Valid @RequestParam("image") MultipartFile file, @Valid @RequestParam("username") String un)
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
    	
    	//boolean f=fileupload.uploadfile(file);
      
//    	if(f) {
//    	  return ResponseEntity.ok("file is successfully uploaded");
//    	  
//    	}
//    	
//    	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!! something went wrong !!");
	}
}




