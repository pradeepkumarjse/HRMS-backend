package com.realcoderz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realcoderz.exception.ResourceNotFoundException;
import com.realcoderz.model.QuestionForm;
import com.realcoderz.model.Result;
import com.realcoderz.repository.IResultRepo;
import com.realcoderz.service.IQuizService;

@RestController
@RequestMapping("/api/v1/quiz")
@CrossOrigin("*")
public class QuizController {
	
	private static final Logger logger=LoggerFactory.getLogger(QuizController.class);

	@Autowired
	private Result result;

	@Autowired
	private IQuizService qService;
	
	@Autowired
	private IResultRepo resultRepo;

	Boolean submitted = false;

	@PostMapping("/start/{username}")	
	public QuestionForm quiz(@Valid @PathVariable("username") String username) {
	logger.info("quiz() called from QuizController");

		if (username.equals("")) {
			return null;
		}
		submitted = false;
		result.setUsername(username);
		QuestionForm qForm = qService.getQuestions();
		return qForm;
	}

	
	

	@ModelAttribute("result")
	public Result getResult() {
		logger.debug("getResult() called from QuizController");
		return result;
	}

	
	
		
	
	
	@PostMapping("/submit")
	public Map<String, Integer> submit(@Valid @RequestBody QuestionForm qForm) {
		logger.debug("submit() called from QuizController");

		if (!submitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			qService.saveScore(result);
			submitted = true;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put(result.getUsername(), result.getTotalCorrect());
		return map;
	}

	
	@GetMapping("/score")
	public List<Result> score() {
		logger.debug("score() called from QuizController");
		List<Result> sList = qService.getTopScore();		
		return sList;
	}
	
	
	@DeleteMapping("/delete-user-score/{id}")
	public Map<String,Boolean> deleteUserScore(@PathVariable("id") int id) throws Exception{
		logger.debug("deleteUserScore() called from QuizController");
		Result result=resultRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Result not found on ::"+id));
		resultRepo.delete(result);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
