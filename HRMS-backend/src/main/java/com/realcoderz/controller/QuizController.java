package com.realcoderz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.realcoderz.model.QuestionForm;
import com.realcoderz.model.Result;
import com.realcoderz.service.IQuizService;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
	
	
	@Autowired
	private Result result;
	
	@Autowired
	private IQuizService qService;

	Boolean submitted=false;
	
	
	
	@PostMapping("/start")
	public QuestionForm quiz(@RequestParam String username) {
		if(username.equals("")) {
			
	     }
		
		submitted=false;
		result.setUsername(username);
		
		QuestionForm qForm=qService.getQuestions();
         return qForm;		
		
	}
	
	
	
	
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}
	
	

	
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm,Model m) {	
		if(!submitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			qService.saveScore(result);
			submitted=true;
		}		
		return "test";
	}
	
	
	@GetMapping("/score")
	public String score(Model m) {
		List<Result> sList=qService.getTopScore();
		m.addAttribute("sList", sList);
		return "scoreboard.html";
		
	}
}
