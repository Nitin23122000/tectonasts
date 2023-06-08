package com.jpaexp2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpaexp2.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {

	//deriverd query methods  custom finder method
	
	  public List<Student>  findBySname(String sname);
	  
	  public List<Student> findBySnameAndCity(String sname,String city );
	  
	  @Query("select s FROM Student s")
	  public List<Student> getAllStudent();
	  
	  @Query("select ss FROM Student ss where ss.sname =:n")
	  public List<Student> getStudentByName( @Param("n") String sname);
	  
	  @Query(value="select * FROM Student where id=?",nativeQuery = true)
	  public List<Student> getStudentDetailsByID( int id);
}
