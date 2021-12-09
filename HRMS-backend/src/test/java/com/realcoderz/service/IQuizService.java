package com.realcoderz.service;

import java.util.List;

import com.realcoderz.model.QuestionForm;
import com.realcoderz.model.Result;

public interface IQuizService {
	public QuestionForm getQuestions();
	public int getResult(QuestionForm qForm);
	public void saveScore(Result result);
	public List<Result> getTopScore();
}
