package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	
	
	/*
	 * @RequestMapping("/example") public String insertdata() { jdbc.
	 * execute("insert into mycrud(name,email) values('Nitin','nitin@123gmail.com')"
	 * ); return "data inserted successfully"; }
	 */
	
	@Autowired
	EmployeeDao empdao;
	
	
	@PostMapping("/post/{name}/{salary}")
	public String insertdata(@PathVariable("name") String name,@PathVariable("salary") int salary, EmployeeBean empbean) {
		this.empdao.insertData(empbean);
		return "data inserted successfully";
	}
	
	@GetMapping("/post/showall")
	public List<EmployeeBean> getAllData() {
		return  this.empdao.getAllData();
		
	}
	
	@GetMapping("/post/{id}")
	public EmployeeBean getById(@PathVariable("id") int id) throws Exception {
		EmployeeBean ebyid = this.empdao.getByid(id);
		if(ebyid==null) {
			return ebyid;
		}
		else {
			return ebyid;
		}
	}
	
	@PutMapping("/posting")
	public EmployeeBean updatedata(EmployeeBean emp)  {
		
		System.out.println(emp.getId());
		 this.empdao.updateData(emp);
		return emp;
		
		/*
		 * if(empdao.updateData(emp)!=0) { return emp; } else { return emp; }
		 */
		
	}
	
	@DeleteMapping("/post/{id}")
	public String deleteData(@PathVariable("id") int id) {
		
		boolean deletedata = this.empdao.deletedata(id);
		
		if(deletedata==true) {
			return "data deleted";
		}
		else {
			return "invalid input";
		}
	}
}
