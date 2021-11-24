package com.realcoderz.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuestionForm {

	public List<Question> questions;

	
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		return "QuestionForm [questions=" + questions + "]";
	}
	
}
