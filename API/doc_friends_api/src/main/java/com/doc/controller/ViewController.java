package com.doc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ViewController {

	@GetMapping("/login")
	public ModelAndView login() {
		log.info("login");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
}
