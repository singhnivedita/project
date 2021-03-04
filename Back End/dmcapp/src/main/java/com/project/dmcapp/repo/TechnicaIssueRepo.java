package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.model.TechnicalIssue;

public interface TechnicaIssueRepo extends JpaRepository<TechnicalIssue, Integer> {

}
