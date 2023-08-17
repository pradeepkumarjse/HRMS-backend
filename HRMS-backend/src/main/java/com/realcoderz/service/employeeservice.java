package com.realcoderz.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.model.Employee;


public interface employeeservice {
	
	public List<Employee> getemployees();
	
	public Employee getemployee(Long empid);
	
	public String addemployee(Employee emp,MultipartFile file);
	
	public Employee updateemployee(Long empid,Employee emp,MultipartFile file);
	
	public Employee deleteemployee(Long empid);

}