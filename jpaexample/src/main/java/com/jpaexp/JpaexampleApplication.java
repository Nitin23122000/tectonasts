package com.jpaexp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpaexp.dao.UserRepository;
import com.jpaexp.entity.user;

@SpringBootApplication
public class JpaexampleApplication {

	public static void main(String[] args) {
    ApplicationContext a = SpringApplication.run(JpaexampleApplication.class, args);
     UserRepository userrepo = a.getBean(UserRepository.class);
     
    user u=new user();
    u.setId(1);
    u.setName("nitin");
    u.setCity("sirohi");
    u.setStatus("coder");
     user u1=userrepo.save(u);
     System.out.println(u1);
     
	}

}
