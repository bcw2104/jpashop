package com.jpashop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/")
	public String home(Model model) {
		
		logger.trace("m trace");
        logger.debug("m debug");
        logger.info("m info");
        logger.warn("m warn");
        logger.error("m error");
		model.addAttribute("data", "hello");
		return "home";
	}
}
