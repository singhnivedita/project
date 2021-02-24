package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    
}
