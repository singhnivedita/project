package com.project.dmcapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {
	
	@Query("Select a from Agent a Where agentId= ?1 AND password =?2")

	Optional<Agent> findByIdAndPassword(int userId, String password);
	
	
}

