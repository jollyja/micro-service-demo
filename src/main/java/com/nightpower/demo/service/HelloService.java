package com.nightpower.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	private static Logger log = LoggerFactory.getLogger(HelloService.class);

	
	public void hello() {
		log.info("this is hello service");
	}
	
	
}
