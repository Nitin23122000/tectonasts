package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbc;

	public void insertData(EmployeeBean empbean) {
		jdbc.update("insert into data(name,salary) values(?,?)", empbean.getName(), empbean.getSalary());

	}

	public List<EmployeeBean> getAllData() {
		return jdbc.query("select * from data ", new BeanPropertyRowMapper<EmployeeBean>(EmployeeBean.class));
	}

	public EmployeeBean getByid(int id) {
		EmployeeBean emp=null;
		
		try {
			emp=jdbc.queryForObject("select * from data where id=?", new Object[] { id} ,new BeanPropertyRowMapper<EmployeeBean>(EmployeeBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public int updateData(EmployeeBean emp) {
		
		return jdbc.update("update data set name=?,salary=? where id=?",emp.getName(),emp.getSalary(),emp.getId());
	}
	
	public boolean deletedata(int id) {
		int delete = jdbc.update("delete from data where id=?",id);
		if(delete==0) {
			return false;
		}
		else {
		return true;	
		}
	}
}
