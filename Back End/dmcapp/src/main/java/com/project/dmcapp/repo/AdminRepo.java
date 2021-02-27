package com.project.dmcapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.Admin;
import com.project.dmcapp.model.Patient;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	
	@Query("Select a from Admin Where adminId= ?1 AND password =?2")
	public Optional<Admin> findByIdAndPassword(int userId,String password);
	
	
	
	
	
	
	
}
