package com.realcoderz.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.realcoderz.exception.ResourceNotFoundException;
import com.realcoderz.model.Question;
import com.realcoderz.repository.IQuestionRepository;


@RestController
@RequestMapping("/api/v1/questions")
@CrossOrigin(origins= "http://localhost:3000")

public class QuestionController {

	private static final String imageDirectory = System.getProperty("user.dir") + "/src/main/webapp/images/question";

	
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
	
	
	@PostMapping(produces = { MediaType.IMAGE_PNG_VALUE, "application/json" })
	public ResponseEntity<Object> insertQuestion(@RequestPart("question") Question ques,@RequestParam("imageName") String imageName,@RequestParam("imageFile") MultipartFile file) {
		System.out.println("QuestionController.insertQuestion()");
		makeDirectoryIfNotExist(imageDirectory);
		Path fileNamePath = Paths.get(imageDirectory,
				imageName.concat(".").concat(FilenameUtils.getExtension(file.getOriginalFilename())));
     
		
		Question q=ques;
		q.setPicPath("http://localhost:4041/images/question/" + imageName + ".png");
		questionRepository.save(q);
		
		
		try {
			Files.write(fileNamePath, file.getBytes());
			return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
		} catch (IOException ie) {
			ie.printStackTrace();
			return new ResponseEntity<>("Question is not added", HttpStatus.BAD_REQUEST);
		}

		
		
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
	

	private void makeDirectoryIfNotExist(String imageDirectory) {
		File directory = new File(imageDirectory);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	
	
	

	
	
	
}
