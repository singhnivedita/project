package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.entities.SecretQuestion;



public interface SecretQuestionRepo extends JpaRepository<SecretQuestion, Integer> {

}
