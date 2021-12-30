package com.realcoderz.helper;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.realcoderz.model.Admin;
import com.realcoderz.repository.AdminRepository;

	
@Component
public class adminfilehelper{
	
	private static final String Upload_Dir = null;

	@Autowired
	private AdminRepository adminrepository;

	public final String
//	UPLOAD_DIR="C:\\Users\\hp\\Downloads\\ReactJS-Spring-Boot-CRUD-Full-Stack-App-master\\"
//		+ "ReactJS-Spring-Boot-CRUD-Full-Stack-App-master\\springboot-backend\\src\\main\\resources\\static\\image";
	
	UPLOAD_DIR="C:\\Users\\hp\\Documents\\workspace-spring-tool-suite-4-4.12.0.RELEASE\\maven.1640604573958\\HRMS-backend\\src\\main\\resources\\static\\adminimages";

	public boolean uploadFile1(Admin admin,MultipartFile multipartFile)
	{ 
		boolean f = false;
		
		try {
			
//            read file
	
		InputStream is = multipartFile.getInputStream();
			byte data[]=new byte[is.available()];
			is.read(data);

////			write file
		
			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
	    	fos.write(data);
	    	
	    	System.out.println(multipartFile+"admin se phle");
	    	Admin admin1=new Admin();
	    	admin1 =admin;
	    	
	    	admin1.setImage(multipartFile.getBytes());
	    	System.out.println(admin1);
	    	
	    	adminrepository.save(admin1);
	    
	    	fos.close();
	    	fos.flush();
			
			
			
//	Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator
//					+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		
			f=true;
			
		}catch (Exception e) {
			
			e.printStackTrace();
	
		}
		
		return f;
	}

	public boolean uploadFile11(Admin admin, MultipartFile file) {
		// TODO Auto-generated method stub
		return false;
	}

}
