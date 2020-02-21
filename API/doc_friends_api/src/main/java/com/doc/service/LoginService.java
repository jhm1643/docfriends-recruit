package com.doc.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.doc.entity.User;

public interface LoginService {

	public ResponseEntity<String> login(User user, HttpServletRequest request);
}
