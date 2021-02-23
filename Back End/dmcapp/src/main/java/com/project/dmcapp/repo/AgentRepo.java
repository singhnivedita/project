package com.project.dmcapp.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.dmcapp.entities.Admin;

public interface AgentRepo extends CrudRepository<Admin, Integer> {

}
