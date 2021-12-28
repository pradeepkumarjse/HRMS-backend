package com.realcoderz.service.impl;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.helper.CsvFileHelper;
import com.realcoderz.model.CsvFile;
import com.realcoderz.repository.CsvFileRepository;
import com.realcoderz.service.CsvfileService;

@Service
public class CsvFileServiceImpl implements CsvfileService {
	
	private static final Logger logger=LoggerFactory.getLogger(CsvFileServiceImpl.class);
	
	@Autowired
	private CsvFileRepository csvfilerepo;
	
	@Autowired
	private CsvFileHelper csvfilehelper;
	
	

	@Override
	public void save(MultipartFile file) {
		
		logger.info("save() called from CsvFileServiceImpl class");
		try {
	  
			List<CsvFile> list=csvfilehelper.convertexceltolist(file.getInputStream());
	   
			this.csvfilerepo.saveAll(list);
			logger.info("file saved successfully");
	   
		}
		catch (Exception e) {
		e.printStackTrace();
		logger.error("something wrong in save() in CsvFileServiceImpl class");
		}
	}

	@Override
	public List<CsvFile> getallrecords() {
	
		logger.info("getallrecords() called from CsvFileServiceImpl class");
		
		return this.csvfilerepo.findAll();
		
		
	}

}
