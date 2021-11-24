package com.realcoderz.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileuploadhelper {

	
	public final String Upload_Dir="C:\\Users\\mohit\\Documents\\workspace-spring-tool-suite-4-4.12.0.RELEASE\\OnlineExam\\src\\main\\resources\\static\\image";

	public boolean uploadfile(MultipartFile multipartfile)
	{
		boolean f=false;
		
		try {
			// read file
			
			/*
			 * InputStream is= multipartfile.getInputStream();
			 * 
			 * byte data[]=new byte[is.available()];
			 * 
			 * is.read(data );
			 * 
			 * //write
			 * 
			 * FileOutputStream fos=new
			 * FileOutputStream(Upload_Dir+"\\"+multipartfile.getOriginalFilename());
			 * 
			 * fos.write(data); fos.close(); fos.flush();
			 */
			
			Files.copy(multipartfile.getInputStream(), Paths.get(Upload_Dir+File.separator+multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
			
			
		f=true;
		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return f;
	}

	
}
