package com.scheduled;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //to enable scheduling
public class ScheduledannotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledannotationApplication.class, args);
		System.out.println("ScheduledannotationApplication.main()"+new Date() );
	}

}
