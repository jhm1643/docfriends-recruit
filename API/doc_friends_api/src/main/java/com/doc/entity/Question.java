package com.doc.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String content;
	private String hashTag;
	private String sourceUrl;
	private LocalDateTime questionDate;
	
	@ManyToOne
	@JoinColumn(name="user_email")
	private User user;
	public void setUser(User user) {
		if(this.user != null) {
			this.user.getQuestions().remove(this);
		}
		this.user = user;
		user.getQuestions().add(this);
	}
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Answer> answers = new ArrayList<>();
}
