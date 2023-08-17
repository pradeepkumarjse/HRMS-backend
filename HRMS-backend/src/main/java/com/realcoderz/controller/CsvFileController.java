package com.realcoderz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.helper.CsvFileHelper;
import com.realcoderz.model.CsvFile;
import com.realcoderz.service.CsvfileService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CsvFileController {
	
	private static final Logger logger=LoggerFactory.getLogger(CsvFileController.class);
	
	@Autowired
	private CsvFileHelper csvfilehelper;
	
//	CsvFileHelper csvfilehelper =new CsvFileHelper();
	
	@Autowired
	private CsvfileService csvfileservice;
	
	@PostMapping("/uploadcsvfile")
	public String upload(@RequestParam("file") MultipartFile file) 
	{
		logger.info("upload() called from CsvFileController");
		
		if (csvfilehelper.checkexcelfile(file)) 
		{
			this.csvfileservice.save(file);
			logger.info("Uploaded");
		  return "file upload";
			
		}
			logger.error("fille not upload");
			return "file not uploaded";				
	}
	
	@GetMapping("/upload")
	public List<CsvFile> getallfile(){
		
		logger.info("getallfile() called from CsvFileController");
		return this.csvfileservice.getallrecords();
	}

}
