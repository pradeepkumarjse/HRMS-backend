package com.realcoderz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realcoderz.model.Question;


public interface IQuestionRepository extends JpaRepository<Question, Integer>{

}
