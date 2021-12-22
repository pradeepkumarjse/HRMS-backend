package com.realcoderz.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.model.Employee;
import com.realcoderz.repository.employeerepository;
import com.realcoderz.service.employeeservice;

import com.realcoderz.service.impl.employeeserviceimpl;
import com.realcoderz.helper.fileuploadhelper;

@Service
public class employeeserviceimpl implements employeeservice {

	@Autowired
	private employeerepository emprepository;
	
	@Autowired
	private fileuploadhelper fileuploadhelper;
	
	
	// get all employee
	
	@Override
	public List<Employee> getemployees() {
		// TODO Auto-generated method stub
		return emprepository.findAll();
	}


	//get employee by id
	
	@Override
	public Employee getemployee(Long empid) {
		
	Optional<Employee>	emp= emprepository.findById(empid);
		
	if(emp.isPresent())
	{
		return emp.get();

	}
	return null;
	}
	
	// insert employee
	
	@Override  
	public String addemployee(Employee emp,MultipartFile file)
	{
		 
		boolean b=fileuploadhelper.uploadfile(emp,file);
		return "uploaded" ;
		
	}

	//update employee
	
	@Override
	public Employee updateemployee(Long empid,Employee emp) {
		
		Optional<Employee>	empp= emprepository.findById(empid);
		
		if(empp.isPresent())
		{
			emprepository.save(emp);
		}
		 
		return emp;
		
	}

	// delete employee

	@Override
	public Employee deleteemployee(Long empid) {
		
		emprepository.deleteById(empid);
		
		return null;
	}

}
