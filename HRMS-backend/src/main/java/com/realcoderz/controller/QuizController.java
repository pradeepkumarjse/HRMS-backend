package com.realcoderz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.realcoderz.model.QuestionForm;
import com.realcoderz.model.Result;
import com.realcoderz.service.impl.QuizServiceImpl;

@Controller
//@RequestMapping("/")
public class QuizController {
	
	@GetMapping("/")
	public String home() {
		 return "index.html";
	}
	
	
	@GetMapping("/startQuiz")
	public String startQuiz() {
		 return "start_quiz.html";
	}
	
	
	
	@Autowired
	private Result result;
	
	@Autowired
	private QuizServiceImpl qService;

	Boolean submitted=false;
	
	
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}
	
	
	@PostMapping("/quiz")
	public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
		if(username.equals("")) {
			ra.addFlashAttribute("Warning ","you must enter your username");
		    return "redirect:/";
	     }
		
		submitted=false;
		result.setUsername(username);
		
		QuestionForm qForm=qService.getQuestions();
		m.addAttribute("qForm", qForm);
		
		return "quiz.html";
	}
	
	
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm,Model m) {
		System.out.println("start");
		System.out.println(qForm);
		System.out.println("end");
		if(!submitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			qService.saveScore(result);
			submitted=true;
		}		
		return "result.html";
	}
	
	
	@GetMapping("/score")
	public String score(Model m) {
		List<Result> sList=qService.getTopScore();
		m.addAttribute("sList", sList);
		return "scoreboard.html";
		
	}
}
