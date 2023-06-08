package com.scheduled.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("testbean")
public class Test {

	//intial delay me app start hone k itne time baad start hoga
	//fixed delay is to time duration 
	
	@Scheduled(initialDelay = 2000 ,fixedDelay = 3000)
	public void run() {
		System.out.println("scheduling ...");
	}
}
