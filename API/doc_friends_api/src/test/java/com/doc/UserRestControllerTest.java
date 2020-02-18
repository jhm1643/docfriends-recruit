package com.doc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.doc.entity.Question;
import com.doc.entity.User;
import com.doc.repo.AnswerRepository;
import com.doc.repo.QuestionRepository;
import com.doc.repo.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class UserRestControllerTest {

	@Autowired
    private TestRestTemplate trt;
	@Autowired
	private UserRepository ur;
	@Autowired
	private AnswerRepository ar;
	@Autowired
	private QuestionRepository qr;
	
//	@Test
//	public void jpaTest() {
//		User user = new User();
//		user.setEmail("abcd");
//		user.setPassword("1234");
//		ur.save(user);
//		Question question = new Question();
//		question.setTitle("t");
//		question.setContent("c");
//		question.setUser(user);
//		qr.save(question);
//		User user2 = ur.findById("abcd").get();
//		assertEquals(user2.getEmail(), "abcd");
//		assertEquals(user2.getQuestions().size(),1);
//		for(Question q2 : user2.getQuestions()) {
//			assertEquals(q2.getTitle(),"t");
//		}
//		
//		assertEquals(qr.findById((long)1).get().getContent(),"c");
//		assertEquals(qr.findById((long)1).get().getUser().getEmail(),"abcd");
//	}
	
//	@Test
//	@Order(1)
//	public void userCreateTest() {
//		User user = new User();
//		user.setEmail("carrey@carrey.com");
//		user.setPassword("1234");
//		try {
//			//URI uri = new URI("http://localhost:"+WebEnvironment.DEFINED_PORT+/doc-talk/user");
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			HttpEntity<User> request = new HttpEntity<User>(user, headers);
//			ResponseEntity<String> result = this.trt.postForEntity("/doc-talk/user", request, String.class);
//			assertEquals(200, result.getStatusCodeValue());
//			assertEquals("success", result.getBody());
//			assertTrue(ur.existsById("carrey@carrey.com"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@Test
	public void questionTest() {
		User user = new User();
		user.setEmail("abcd");
		user.setPassword("1234");
		ur.save(user);
		Question question = new Question();
		question.setTitle("t");
		question.setContent("c");
		question.setUser(user);
		qr.save(question);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String uri = "/doc-talk/question";
		ResponseEntity<Question[]> response =trt.getForEntity(uri, Question[].class);
		assertEquals(200,response.getStatusCodeValue());
	}
	
//	@Test
//	@Order(2)
//	public void questionCommonTest() {
//		Question question = new Question();
//		question.setTitle("title");
//		question.setContent("contents");
//		question.setUser(ur.findById("carrey@carrey.com").get());
//		try {
//			//URI uri = new URI("http://localhost:8080/doc-talk/question");
//			String uri = "/doc-talk/question";
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			
//			//questionCreateTest
//			HttpEntity<Question> createRequest = new HttpEntity<Question>(question, headers);
//			ResponseEntity<String> createResult = this.trt.postForEntity(uri, createRequest, String.class);
//			assertEquals(200, createResult.getStatusCodeValue());
//			assertEquals("success", createResult.getBody());
//			//questionListReadtTest
//			ResponseEntity<Question[]> response =trt.getForEntity(uri, Question[].class);
//			List<Question> list = java.util.Arrays.asList(response.getBody());
//			for(Question q : list) {
//				assertEquals(q.getTitle(), "title");
//				assertEquals(q.getContent(), "contents");
//				
//				//questionReadTest
//				ResponseEntity<Question> response2 = trt.getForEntity(uri+"/"+q.getId(), Question.class);
//				assertEquals("title",response2.getBody().getTitle());
//				assertEquals("contents",response2.getBody().getContent());
//				assertEquals("carrey@carrey.com",response2.getBody().getUser().getEmail());
//				
//				//questionUpdateTest
//				Question updateQuestion = response2.getBody();
//				updateQuestion.setTitle("title2");
//				updateQuestion.setContent("contents2");
//				HttpEntity<Question> updateRequest = new HttpEntity<Question>(updateQuestion, headers);
//				ResponseEntity<String> updateResult = trt.exchange(uri, HttpMethod.PUT, updateRequest, String.class);
//				assertEquals(updateResult.getStatusCodeValue(), 200);
//				assertEquals(updateResult.getBody(), "success");
//				assertEquals("title2", qr.findById(q.getId()).get().getTitle());
//				assertEquals("contents2", qr.findById(q.getId()).get().getContent());
//				
//				//questionDeleteTest
//				ResponseEntity<String> deleteResult = trt.exchange(uri+"/"+q.getId(), HttpMethod.DELETE, null, String.class);
//				assertEquals(deleteResult.getStatusCodeValue(), 200);
//				assertEquals(deleteResult.getBody(), "success");
//				assertFalse(qr.findById(q.getId()).isPresent());
//			}
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

}
