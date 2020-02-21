package com.doc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.doc.entity.Answer;
import com.doc.entity.Question;
import com.doc.entity.User;

public interface CRUDService {

	public ResponseEntity<String> userCreate(User user);
	public ResponseEntity<User> userRead(String email);
	
	public ResponseEntity<String> questionCreate(Question question, String email);
	public ResponseEntity<Question> questionRead(long id);
	public ResponseEntity<List<Question>> questionListRead();
	public ResponseEntity<String> questionUpdate(Question question);
	public ResponseEntity<String> questionDelete(long id);
	
	public ResponseEntity<String> answerCreate(Answer answer, long question_id);
	public ResponseEntity<Answer> answerRead(long id);
	public ResponseEntity<List<Answer>> answerListRead();
	public ResponseEntity<String> answerUpdate(Answer answer);
	public ResponseEntity<String> answerDelete(long id);
	
}
