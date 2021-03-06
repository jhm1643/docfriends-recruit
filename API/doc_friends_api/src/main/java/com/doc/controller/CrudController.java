package com.doc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doc.entity.Answer;
import com.doc.entity.Question;
import com.doc.entity.User;
import com.doc.service.CRUDService;


@RestController
@RequestMapping("/doc-talk")
public class CrudController {

	@Autowired
	private CRUDService crudService;
	
	/****************************************** User CRUD ******************************************/
	@PostMapping("/user")
	public ResponseEntity<String> userCreate(@RequestBody User user){
		return crudService.userCreate(user);
	}
	
	@GetMapping("/user/{email}")
	public ResponseEntity<User> userRead(@PathVariable("email") String email){
		return crudService.userRead(email);
	}
	/****************************************** Question CRUD ******************************************/
	@PostMapping("/question/{email}")
	public ResponseEntity<String> questionCreate(@RequestBody Question question,
												 @PathVariable("email") String email){
		return crudService.questionCreate(question, email);
	}
	
	@GetMapping("/question/{id}")
	public ResponseEntity<Question> questionRead(@PathVariable("id") long id){
		return crudService.questionRead(id);
	}
	
	@GetMapping("/question")
	public ResponseEntity<List<Question>> questionListRead(){
		return crudService.questionListRead();
	}
	
	@PutMapping("/question")
	public ResponseEntity<String> questionUpdate(@RequestBody Question question){
		return crudService.questionUpdate(question);
	}
	
	@DeleteMapping("/question/{id}")
	public ResponseEntity<String> questionDelete(@PathVariable("id") long id){
		return crudService.questionDelete(id);
	}
	
	/****************************************** Answer CRUD ******************************************/
	@PostMapping("/answer/{question_id}")
	public ResponseEntity<String> answerCreate(@RequestBody Answer answer,
											   @PathVariable("question_id") long question_id){
		return crudService.answerCreate(answer, question_id);
	}
	
	@GetMapping("/answer/{id}")
	public ResponseEntity<Answer> answerRead(@PathVariable("id") long id){
		return crudService.answerRead(id);
	}
	
	@GetMapping("/answer")
	public ResponseEntity<List<Answer>> answerListRead(){
		return crudService.answerListRead();
	}
	
	@PutMapping("/answer")
	public ResponseEntity<String> answerUpdate(@RequestBody Answer answer){
		return crudService.answerUpdate(answer);
	}
	
	@DeleteMapping("/answer/{id}")
	public ResponseEntity<String> answerDelete(@PathVariable("id") long id){
		return crudService.answerDelete(id);
	}
}
