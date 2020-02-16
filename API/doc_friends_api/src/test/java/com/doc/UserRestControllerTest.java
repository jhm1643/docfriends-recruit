package com.doc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.doc.entity.User;
import com.doc.repo.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserRestControllerTest {

	@Autowired
    private TestRestTemplate trt;
	@Autowired
	private UserRepository ur;
	@Test
	public void testPostUser() {
		User user = new User();
		user.setId("carrey");
		user.setPassword("1234");
		try {
			URI uri = new URI("http://localhost:8080/doc-talk/user");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<User> request = new HttpEntity<User>(user, headers);
			ResponseEntity<User> result = this.trt.postForEntity(uri, request, User.class);
			assertEquals(200, result.getStatusCodeValue());
			assertTrue(ur.existsById("carrey"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
