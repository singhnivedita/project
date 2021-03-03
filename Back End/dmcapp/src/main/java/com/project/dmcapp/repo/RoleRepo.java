package com.project.dmcapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    
	@Query("select r from Role r where roleId =?1")
	public List<Role> findRoleById(int roId);
}
