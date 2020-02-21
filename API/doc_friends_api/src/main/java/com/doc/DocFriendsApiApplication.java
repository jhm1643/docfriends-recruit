package com.doc;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Transactional;

import com.doc.entity.Answer;
import com.doc.entity.Question;
import com.doc.entity.User;
import com.doc.repo.AnswerRepository;
import com.doc.repo.QuestionRepository;
import com.doc.repo.UserRepository;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
public class DocFriendsApiApplication {

	@Autowired
	private UserRepository ur;
	@Autowired
	private QuestionRepository qr;
	@Autowired
	private AnswerRepository ar;
	public static void main(String[] args) {
		SpringApplication.run(DocFriendsApiApplication.class, args);
	}

	@Bean
	@Transactional
	public void userDataSet() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setPassword("1234");
		ur.save(user);
		
		Question q1 = new Question();
		q1.setTitle("수원 24/남 여드름...");
		q1.setContent("제가 얼굴이며 몸이며...");
		q1.setSourceUrl("http://test.com");
		q1.setHashTag("#한방 피부과");
		q1.setUser(ur.findById("test@test.com").get());
		qr.save(q1);
		
		Question q2 = new Question();
		q2.setTitle("울산 23/여 여드름...");
		q2.setContent("선크림 영향인지 모르겠지만...");
		q2.setSourceUrl("http://test.com");
		q2.setHashTag("#한방 피부과");
		q2.setUser(ur.findById("test@test.com").get());
		qr.save(q2);
		
		Question q3 = new Question();
		q3.setTitle("수지풍덕천 37/남 교통사고 한의원치료...");
		q3.setContent("교통사고로 팔 수술을 하였습니다. 현재 깁스 하면서...");
		q3.setSourceUrl("http://test.com");
		q3.setHashTag("#한방재활의학과");
		q3.setUser(ur.findById("test@test.com").get());
		qr.save(q3);
		
		Answer a1 = new Answer();
		a1.setTitle("정동원 원장님의 답변");
		a1.setContent("안녕하세요. 닥톡-네이버 지식iN 상담한의사 정동원입니다....");
		a1.setQuestion(qr.findById((long)1).get());
		ar.save(a1);
	}
}
