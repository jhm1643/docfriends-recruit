package com.doc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doc.entity.User;
import com.doc.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/doc-talk")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		log.info("login");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> loginTry(@RequestBody User user,
										   HttpServletRequest request){
		return loginService.login(user,request);
	}
}
