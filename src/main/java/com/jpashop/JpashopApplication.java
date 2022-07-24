package com.jpashop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpashop.controller.MainController;

@SpringBootApplication
public class JpashopApplication {

	private static final Logger logger = LoggerFactory.getLogger(JpashopApplication.class);
	
	public static void main(String[] args) {
		logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
		SpringApplication.run(JpashopApplication.class, args);
	}

}
