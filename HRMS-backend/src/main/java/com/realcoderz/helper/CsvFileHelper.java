package com.realcoderz.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.realcoderz.model.CsvFile;

@Component
public class CsvFileHelper {
	
	private static final Logger logger=LoggerFactory.getLogger(CsvFileHelper.class);
// check file is excel type or not
	public static boolean checkexcelfile(MultipartFile file)
	{
		String contenttype=file.getContentType();
		
		// this is content type of e
		if(contenttype.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
		{
			logger.info("excel sheet is valid");
			return true;
		}
		else {
			logger.info("plz check file formate");
			return false;
		}
		
		
	}
	
	//converting excel to list of csvfile
	
	public List<CsvFile> convertexceltolist(InputStream is)
	{
		logger.info("convertexceltolist() callled from CsvFileHelper class");
	List<CsvFile> list=	new ArrayList<>();
	
	try {
		
		
	XSSFWorkbook workbook=new XSSFWorkbook(is);
	
	// this is sheet name in excel sheet
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        
        int rownumber=0;
        
      Iterator<Row> iterator= sheet.iterator();
      
      while(iterator.hasNext()) {
    	  
    	  
    	  Row row=iterator.next();
    	  
    	  // we don't take first row data
    	  if(rownumber==0) 
    	  {
    		rownumber++;
    		continue;
    	  }
    	  
    	Iterator<Cell> cells= row.iterator();
    	
    	int cid=0;
    	
    	CsvFile data=new CsvFile();
    	
    	while(cells.hasNext()) 
    	{
    		Cell cell=cells.next();
    		
    		switch (cid)
    		{
			case 0: {
				
				data.setId((int)cell.getNumericCellValue());
				break;
			}
			
			case 1:{
				data.setName(cell.getStringCellValue());
				break;
			}
			
			case 2:{
				data.setCollege(cell.getStringCellValue());
				break;
			}
			
			
			case 3:{
				data.setCity(cell.getStringCellValue());
				break;
			}
			
			default:
				break;
			}
    		cid++;
    	}
    	
    	list.add(data);
      }
	
	}
	catch (Exception e) {
		e.printStackTrace();
		logger.info("Exception occur in convertexceltolist() in CsvFileHelper class");
	}
	
	return list;
		
		
	}

}
