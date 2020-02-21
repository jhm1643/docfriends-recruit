package com.doc.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.doc.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
