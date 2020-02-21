package com.doc.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doc.entity.User;
import com.doc.repo.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public ResponseEntity<String> login(User user, HttpServletRequest request) {
		if(userRepo.countByEmailAndPassword(user.getEmail(), user.getPassword())<1) {
			return new ResponseEntity<String>("fail",HttpStatus.OK);
		}
		request.setAttribute("id", user.getEmail());
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

}
