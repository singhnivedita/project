package com.project.dmcapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	@Query("Select a from Admin a Where adminId= ?1 AND password =?2")

	Optional<Admin> findByIdAndPassword(int userId, String password);

	
	
}
