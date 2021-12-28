package com.realcoderz.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.model.Employee;

import com.realcoderz.repository.employeerepository;




@Component
public class fileuploadhelper {

	private static final Logger logger=LoggerFactory.getLogger(fileuploadhelper.class);
	
	@Autowired
	private employeerepository emprepository;
	
	public final String Upload_Dir="C:\\Users\\mohit\\Documents\\workspace-spring-tool-suite-4-4.12.0.RELEASE\\OnlineExam\\src\\main\\resources\\static\\image";

	public boolean uploadfile(Employee emp,MultipartFile multipartfile)
	{
		logger.info("uploadfile() called from fileuploadhelper class");
		boolean f=false;
		
		try {
			// read file
			
			
			 InputStream is= multipartfile.getInputStream();
			 
			 byte data[]=new byte[is.available()];
			   
			  is.read(data );
			  
			  //write  
			 
			  FileOutputStream fos=new FileOutputStream(Upload_Dir+"\\"+multipartfile.getOriginalFilename());
			  
			  fos.write(data); 
			  
			  Employee em=new Employee();
			  em=emp;
			  em.setImage(multipartfile.getBytes());
//			  
			  
			  emprepository.save(em);
			  logger.info("Record Saved");
			  
			  fos.close(); 
			  fos.flush();
			 
			
//			Files.copy(multipartfile.getInputStream(), Paths.get(Upload_Dir+File.separator+multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);	
			
			
		f=true;
		
		}
		catch(Exception e) 
		{
			logger.error("error occur in fileuploadhelper class");
			e.printStackTrace();
		}
		
		
		return f;
	}

	
}
