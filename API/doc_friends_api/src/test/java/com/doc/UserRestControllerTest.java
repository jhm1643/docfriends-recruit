package com.doc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Contains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.doc.entity.Question;
import com.doc.entity.User;
import com.doc.repo.AnswerRepository;
import com.doc.repo.QuestionRepository;
import com.doc.repo.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserRestControllerTest {

	@Autowired
    private TestRestTemplate trt;
	@Autowired
	private UserRepository ur;
	@Autowired
	private AnswerRepository ar;
	@Autowired
	private QuestionRepository qr;
	//@Test
	public void userCreateTest() {
		User user = new User();
		user.setEmail("carrey@carrey.com");
		user.setPassword("1234");
		try {
			URI uri = new URI("http://localhost:8080/doc-talk/user");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<User> request = new HttpEntity<User>(user, headers);
			ResponseEntity<String> result = this.trt.postForEntity(uri, request, String.class);
			assertEquals(200, result.getStatusCodeValue());
			assertEquals("success", result.getBody());
			assertTrue(ur.existsById("carrey@carrey.com"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void questionCreateTest() {
		Question q = new Question();
		q.setTitle("title");
		q.setContent("contents");
		try {
			URI uri = new URI("http://localhost:8080/doc-talk/question");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Question> request = new HttpEntity<Question>(q, headers);
			ResponseEntity<String> result = this.trt.postForEntity(uri, request, String.class);
			assertEquals(200, result.getStatusCodeValue());
			assertEquals("success", result.getBody());
			Iterator<Question> it = qr.findAll().iterator();
			while(it.hasNext()) {
				assertEquals(it.next().getTitle(), "title");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
