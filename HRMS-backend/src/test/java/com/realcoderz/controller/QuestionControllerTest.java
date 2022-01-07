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


import com.realcoderz.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class QuestionControllerTest {
	
	
	@Autowired
	private TestRestTemplate restTemplate;

	
	
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	
	
	@Test
	public void testGetAllQuestions() {
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/api/v1/questions",HttpMethod.GET,entity,String.class);
		Assert.assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetQuestionById() {
		int id=66;
		Question question=restTemplate.getForObject(getRootUrl()+"/api/v1/questions/"+id,Question.class);			
	   
		Assert.assertNotNull(question);
	    
	}
	
	@Test
	public void testCreateQuestion() {
		Question question=new Question();
		question.setQuestion("kjdgkjrgrghregh");
		question.setOp1("pooipoipoipoipo");
		question.setOp2("ioio");
		question.setOp3("ohoihoihihihihihi");
		question.setOp4("ojoioihhihhh");
		question.setAns_option(1);
		question.setChoose(0);   
		
		ResponseEntity<Question> postResponse=restTemplate.postForEntity(getRootUrl()+"/api/v1/questions", question, Question.class);
		Assert.assertNotNull(postResponse);
		Assert.assertTrue(postResponse.getStatusCodeValue()==201);	
		
	}
	
	
	@Test
	public void testUpdateQuestion() {
		int id=78;
		Question question=restTemplate.getForObject(getRootUrl()+"/api/v1/questions/"+id, Question.class);
		
		question.setOp1("memory segment");
		question.setOp2("Block segment");
		
		restTemplate.put(getRootUrl()+"/api/v1/questions/"+id, question);
		
		Question updatedUser=restTemplate.getForObject(getRootUrl()+"/api/v1/questions/"+id, Question.class);
	    Assert.assertNotNull(updatedUser);
	}
	
	
	@Test
	public void testDeleteQuestion() {
		int id=91;
		Question question=restTemplate.getForObject(getRootUrl()+"/api/v1/questions/"+id, Question.class);
		Assert.assertNotNull(question);
		
		restTemplate.delete(getRootUrl()+"/api/v1/questions/"+id);
		try {
			question=restTemplate.getForObject(getRootUrl()+"/api/v1/questions/"+id, Question.class);
		}
		catch(final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}
