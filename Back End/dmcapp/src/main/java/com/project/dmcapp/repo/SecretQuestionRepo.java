package com.project.dmcapp.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.dmcapp.entities.SecretQuestion;



public interface SecretQuestionRepo extends CrudRepository<SecretQuestion, Integer> {

}
