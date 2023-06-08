package com.jpaexp2;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpaexp2.dao.StudentRepository;
import com.jpaexp2.entity.Student;

@SpringBootApplication
public class Jpaexp2Application {

	public static void main(String[] args) {
		ApplicationContext a = SpringApplication.run(Jpaexp2Application.class, args);
		StudentRepository str = a.getBean(StudentRepository.class);

		/*
		 * Student s=new Student(); s.setId(111); s.setSname("sallu bhai");
		 * s.setCity("mars"); s.setAge(99); str.save(s);
		 * 
		 * Student s2=new Student(); s2.setId(55); s2.setSname("amrit");
		 * s2.setCity("sindrath"); s2.setAge(55);
		 * 
		 * Student s3=new Student(); s3.setId(45); s3.setAge(88); s3.setSname("yb");
		 * s3.setCity("kiwarli");
		 * 
		 * List<Student> list = List.of(s,s2,s3);
		 * 
		 * Iterable<Student> result = str.saveAll(list);
		 * 
		 * result.forEach(user->{ System.out.println(user); });
		 * 
		 * }
		 */

		// updating the data

		/*
		 * Optional<Student> optional = str.findById(104); Student res = optional.get();
		 * res.setSname("hello"); 
		 *
		 *Dont forget to save after updating
		 * 
		 * Student result = str.save(res);
		 * System.out.println(result);
		 */

		// fetching the single data
		/*
		 * Optional<Student> optional = str.findById(105);
		 * 
		 * Student result = optional.get(); System.out.println(result);
		 */

		// fetching the multiple data

		//Iterable<Student> itr = str.findAll();

		// By lamda expression

		/*
		 * itr.forEach(new Consumer<Student>() {
		 * 
		 * @Override public void accept(Student t) { // TODO Auto-generated method stub
		 * System.out.println(t); } });
		 */

		/*
		 * itr.forEach(Student->{ System.out.println(Student); });
		 */
		// by normal iteration

		/*
		 * Iterator<Student> iterator = itr.iterator(); while(iterator.hasNext()) {
		 * Student next = iterator.next(); System.out.println(next); }
		 */

		// deleting the data
		/*
		 * str.deleteById(103); System.out.println("data deleted");
		 */

		/*
		 * Iterable<Student> delly = str.findAll(); str.deleteAll(delly);
		 */
		
		/*
		 * List<Student> name = str.findBySname("sallu bhai");
		 * 
		 * name.forEach(naam->{ System.out.println(naam);
		 * 
		 * });
		 */
		
		/*
		 * List<Student> data = str.findBySnameAndCity("hello", "sindrath");
		 * 
		 * data.forEach(dd->{ System.out.println(dd); });
		 */
		
		/*
		 * List<Student> allStudent = str.getAllStudent();
		 * 
		 * allStudent.forEach(qq->{ System.out.println(qq); });
		 */
		
		/*
		 * List<Student> stByName = str.getStudentByName("hello");
		 * 
		 * stByName.forEach(st->{ System.out.println(st); });
		 */
		/*
		 * List<Student> studentDetails = str.getStudentDetails();
		 * 
		 * studentDetails.forEach(sd->{ System.out.println(sd); });
		 */
		
		List<Student> sid = str.getStudentDetailsByID(105);
		
		sid.forEach(sos->{
			System.out.println(sos);
		});
	}
}
