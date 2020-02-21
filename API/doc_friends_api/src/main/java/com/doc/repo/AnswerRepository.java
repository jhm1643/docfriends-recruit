package com.doc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doc.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
