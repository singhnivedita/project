package com.project.dmcapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.Agent;
import com.project.dmcapp.model.Patient;

public interface AgentRepo extends JpaRepository<Agent, Integer> {
	
	@Query("Select a from Agent Where agentId= ?1 AND password =?2")
	public Optional<Agent> findByIdAndPassword(int userId,String password);
}

