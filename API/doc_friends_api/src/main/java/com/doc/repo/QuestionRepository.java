package com.doc.repo;

import org.springframework.data.repository.CrudRepository;

import com.doc.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

}
