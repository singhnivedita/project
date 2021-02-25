package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.entities.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {
	
	
}

