package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class filecontroller {
	
	@Autowired
	private fileuploadhelper fileuploadhelper;
	
	
		@PostMapping("/upload-file")
		public ResponseEntity<String> uploadfile(@RequestParam("hello") MultipartFile file){
			
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getName());
			System.out.println(file.getSize());
			System.out.println(file.getContentType());
			
			try {
			//basic file validation
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file must be there");
			
			}
			
			/*
			 * //content type validation if(!file.getContentType().equals("image/jpg")) {
			 * return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
			 * body("file must be in avif format"); }
			 */
			//file uploading code
			
			boolean f= fileuploadhelper.uploadFile(file);
			
			if(f) {
				//return ResponseEntity.ok("file uploaded successfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
										//upload hone k baad us image ka url return kia
			}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}

}
