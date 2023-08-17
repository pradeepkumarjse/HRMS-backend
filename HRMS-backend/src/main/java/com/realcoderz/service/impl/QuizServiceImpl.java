package com.realcoderz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.realcoderz.model.Question;
import com.realcoderz.model.QuestionForm;
import com.realcoderz.model.Result;
import com.realcoderz.repository.IQuestionRepository;
import com.realcoderz.repository.IResultRepo;
import com.realcoderz.service.IQuizService;

@Service
public class QuizServiceImpl implements IQuizService{	
	
	private static final Logger logger=LoggerFactory.getLogger(QuizServiceImpl.class);
	
	@Autowired
	private QuestionForm qForm;
	
	@Autowired	
	private IQuestionRepository qRepo;	
	
	@Autowired
	private IResultRepo rRepo;
	
	
	public QuestionForm getQuestions() {	
		
		logger.debug("getQuestions() called from QuizServiceImpl class");
		List<Question> allQues=qRepo.findAll();
		List<Question> qList=new ArrayList<Question>();		
		Random random=new Random();		
		for(int i=0;i<8;i++) {
			int rand=random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}
		qForm.setQuestions(qList);		
		return qForm;
	}
	
	
	
	public int getResult(QuestionForm qForm) {
		
		logger.debug("getResult() called from QuizServiceImpl class");
		int correct=0;		
		for(Question q:qForm.getQuestions())			
			if(q.getAns_option()==q.getChoose())
				correct++;		
		return correct;
	}
	
	
	public void saveScore(Result result) {
		logger.debug("saveScore() method called from QuizServiceImpl class ");
		Result saveResult=new Result();
		saveResult.setUsername(result.getUsername());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}
	
	
	
	public List<Result> getTopScore(){
		logger.debug("getTopScore() called from QuizServiceImpl class");
		List<Result> sList=rRepo.findAll(Sort.by(Sort.Direction.DESC,"totalCorrect"));
		return sList;
	}
	

}
