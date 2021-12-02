package com.realcoderz.service;

import java.util.List;

import com.realcoderz.model.Employee;



public interface employeeservice {
	
	public List<Employee> getemployees();
	
	public Employee getemployee(Long empid);
	
	public Employee addemployee(Employee emp);
	
	public Employee updateemployee(Long empid,Employee emp);
	
	public Employee deleteemployee(Long empid);

}
