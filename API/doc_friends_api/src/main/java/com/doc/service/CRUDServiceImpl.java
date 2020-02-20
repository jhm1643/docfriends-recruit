package com.doc.service;

import java.time.LocalDateTime;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doc.entity.Answer;
import com.doc.entity.Question;
import com.doc.entity.User;
import com.doc.repo.AnswerRepository;
import com.doc.repo.QuestionRepository;
import com.doc.repo.UserRepository;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CRUDServiceImpl implements CRUDService {

	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerRepository answerRepo;
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public ResponseEntity<String> userCreate(User user) {
		if(userRepo.existsById(user.getEmail())) {
			return new ResponseEntity<String>("exist email",HttpStatus.OK);
		}
		userRepo.save(user);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> userRead(String email) {
		return new ResponseEntity<User>(userRepo.findById(email).get(),HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<String> questionCreate(Question question, String email) {
		question.setUser(userRepo.findById(email).get());
		questionRepo.save(question);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Question> questionRead(long id) {
		return new ResponseEntity<Question>(questionRepo.findById(id).get(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Iterable<Question>> questionListRead() {
		return new ResponseEntity<Iterable<Question>>(questionRepo.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> questionUpdate(Question question) {
		questionRepo.save(question);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> questionDelete(long id) {
		questionRepo.deleteById(id);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> answerCreate(Answer answer, long question_id) {
		answer.setQuestion(questionRepo.findById(question_id).get());
		answerRepo.save(answer);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Answer> answerRead(long id) {
		return new ResponseEntity<Answer>(answerRepo.findById(id).get(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Iterable<Answer>> answerListRead() {
		return new ResponseEntity<Iterable<Answer>>(answerRepo.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> answerUpdate(Answer answer) {
		answerRepo.save(answer);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> answerDelete(long id) {
		answerRepo.deleteById(id);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

}
