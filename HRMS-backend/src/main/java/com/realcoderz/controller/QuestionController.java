package com.realcoderz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.realcoderz.exception.ResourceNotFoundException;
import com.realcoderz.model.Question;
import com.realcoderz.model.QuestionForm;
import com.realcoderz.model.Result;
import com.realcoderz.repository.IQuestionRepository;
import com.realcoderz.service.impl.QuizServiceImpl;


@RestController
@RequestMapping("/api/v1/questions")
//@CrossOrigin(origins= "http://localhost:3000")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private IQuestionRepository questionRepository;

	
	@GetMapping
	public List<Question> getallQuestions() {
		 return questionRepository.findAll();
	}    

	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") int id) throws ResourceNotFoundException {
		Question question= questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question no found on ::"+id));
		 return ResponseEntity.ok().body(question);
	}
	
	@PostMapping
	public ResponseEntity<Object> insertQuestion(@RequestBody Question ques) {
		System.out.println("QuestionController.insertQuestion()");
		questionRepository.save(ques);
		return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateQuestionById(@PathVariable("id") int id, @RequestBody Question ques) throws ResourceNotFoundException {	
		Question question=questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Question not found on : "+id));
		question.setQuestion(ques.getQuestion());
		question.setOp1(ques.getOp1());
		question.setOp2(ques.getOp2());
		question.setOp3(ques.getOp3());
		question.setOp4(ques.getOp4());
		question.setAns_option(ques.getAns_option());		
		final Question updatedQuestion=questionRepository.save(question);		
		return ResponseEntity.ok(updatedQuestion);
	}
	
	

	
	@DeleteMapping("/{id}")
	public Map<String,Boolean> deleteById(@PathVariable("id") int id) throws Exception {
		Question question=questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question not found on ::"+id));
		questionRepository.delete(question);		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);		
		return response;
	}
	


	
	
	

	
	
	
}
