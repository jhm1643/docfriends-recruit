package com.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.entity.User;
import com.doc.repo.UserRepository;


@RestController
@RequestMapping("/doc-talk")
public class UserRestController {

	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/user")
	public ResponseEntity<String> userAdd(@RequestBody User user) {
		try {
			userRepo.save(user);
		}catch(Exception e) {
			e.printStackTrace();
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
}
