package com.doc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doc.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
