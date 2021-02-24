package com.project.dmcapp.repo;

import com.project.dmcapp.entities.TestResult;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepo extends JpaRepository <TestResult, Integer>{
    
}
