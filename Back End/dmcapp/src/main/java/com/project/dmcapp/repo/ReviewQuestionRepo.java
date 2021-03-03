package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.model.ReviewQuestion;

public interface ReviewQuestionRepo extends JpaRepository<ReviewQuestion, Integer> {

}
