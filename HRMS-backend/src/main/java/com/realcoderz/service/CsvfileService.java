package com.realcoderz.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.model.CsvFile;

public interface CsvfileService {
	
	public void save(MultipartFile file);
	public List<CsvFile> getallrecords();

}
