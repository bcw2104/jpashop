package com.jpashop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jpashop.domain.Address;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		log.trace("m trace");
		log.debug("m debug");
		log.info("m info");
		log.warn("m warn");
		log.error("m error");
		model.addAttribute("data", "hello");
		return "home";
	}
}
