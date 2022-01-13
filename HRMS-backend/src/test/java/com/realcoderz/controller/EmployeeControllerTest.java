package com.realcoderz.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.realcoderz.model.Employee;
import com.realcoderz.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {
 
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
//	
//	@Test
//	public void testGetAllEmployees() {
//		HttpHeaders headers=new HttpHeaders();
//		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
//		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/realcoder/api/employees",HttpMethod.GET,entity,String.class);
//		Assert.assertNotNull(response.getBody());
//	}
//	
//	@Test
//	public void testGetEmployeeById() {
//		String empid="1010";
//		Employee employee=restTemplate.getForObject(getRootUrl()+"/realcoder/api/employees/"+empid,Employee.class);			
//	   	Assert.assertNotNull(employee);
//
//	}
//	
//	@Test
//	public void testDeleteEmployeeById() {
//		String id="";
//		Employee employee=restTemplate.getForObject(getRootUrl()+"/realcoder/api/employees/"+id, Employee.class);
//	    Assert.assertNotNull(employee);
//	    
//	    restTemplate.delete(getRootUrl()+"/realcoder/api/employees/"+id);
//	    try {
//	    	employee=restTemplate.getForObject(getRootUrl()+"/realcoder/api/employees/"+id,Employee.class);
//	    }catch(final HttpClientErrorException e) {
//	    	Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@Test
//	public void testUpdateEmployee() {
//	 String id="1012";
//	 Employee employee=restTemplate.getForObject(getRootUrl()+"/realcoder/api/employees/"+id, Employee.class, Employee.class);
//	 employee.setE_city("Banaras");
//	 employee.setE_name("Bhai Chauhan");
//	 employee.setE_password("chauhan");
//	 employee.setAddress("faridabad");
//	 employee.setE_email("bhaichauhan89898@gmail.com");
//	 employee.setE_userid("bhauchauna");
//	
//
//	 restTemplate.put(getRootUrl()+"/realcoder/api/employees/"+id, employee);
//	 
//	 Employee updatedEmployee=restTemplate.getForObject(getRootUrl()+"/realcoder/api/employees/"+id, Employee.class);
//	  System.out.println("+++++++++++");
//	  System.out.println(updatedEmployee.getAddress());
//	 System.out.println(updatedEmployee);
//	 Assert.assertNotNull(updatedEmployee);
//	 
//	}
//	
//	
	
	
}
