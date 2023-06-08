package com.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@Autowired
	dao dao;
	
	@PostMapping("/jdbc/{id}/{name}/{city}/{email}")
	public String insertStudent(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("city") String city,@PathVariable("email") String email, entity e) {
		 this.dao.insertStudent(e);
		return "data inserted successfully";
	}

	@GetMapping("/jdbc")
	public List<entity>  getAllStudent(){
		return this.dao.getAllStudent();
		
	}
	
	@GetMapping("/jdbc/{id}")
	public entity getById(@PathVariable("id") int id) {
		entity byId = this.dao.getById(id);
		return byId;
	}
	
	@PutMapping("/jdbc/{id}/{name}/{city}/{email}")
	public entity updateStudent(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("city") String city,@PathVariable("email") String email ,entity ee) {
		
		this.dao.updateEntity(ee);
		return ee;
	}
	
	@DeleteMapping("/jdbc/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		boolean result = this.dao.deletestudent(id);
		
		if(result==true) {
			return "data deleted successfully";
		}
		else {
			return "invalid input";
		}
		}
		
}
