package com.storozh.firstnameservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstnameServiceApplication {
    
    private static final Logger LOG = LoggerFactory.getLogger(FirstnameServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FirstnameServiceApplication.class, args);
        LOG.info("Application firstname started");
	}

}
