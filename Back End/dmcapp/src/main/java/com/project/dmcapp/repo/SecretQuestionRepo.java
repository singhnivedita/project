package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.model.SecretQuestion;



public interface SecretQuestionRepo extends JpaRepository<SecretQuestion, Integer> {

}
