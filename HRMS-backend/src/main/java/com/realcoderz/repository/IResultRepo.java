package com.realcoderz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realcoderz.model.Result;


public interface IResultRepo extends JpaRepository<Result, Integer>{

}
