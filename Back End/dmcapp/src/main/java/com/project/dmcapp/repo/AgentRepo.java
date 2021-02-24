package com.project.dmcapp.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.dmcapp.entities.Admin;
import com.project.dmcapp.entities.Agent;

public interface AgentRepo extends CrudRepository<Agent, Integer> {

}
