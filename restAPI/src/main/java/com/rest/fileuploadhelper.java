package com.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileuploadhelper {

	//public final String UPLOAD_DIR ="C:\\Users\\test\\Documents\\workspace-spring-tool-suite-4-4.18.1.RELEASE\\restAPI\\src\\main\\resources\\static\\images";
	public final String UPLOAD_DIR = new ClassPathResource("/static/images/").getFile().getAbsolutePath();

	public fileuploadhelper() throws IOException {
		
	}
	
	public boolean uploadFile(MultipartFile multipart) {
		
		boolean f=false;
		
		try {
			
			/*
			 * //old method
			 * 
			 * InputStream is= multipart.getInputStream(); byte b[]=new
			 * byte[is.available()]; is.read(b);
			 * 
			 * //write FileOutputStream fos=new
			 * FileOutputStream(UPLOAD_DIR+File.separator+multipart.getOriginalFilename());
			 * fos.write(b); fos.flush(); fos.close();
			 */
			
			Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
}
