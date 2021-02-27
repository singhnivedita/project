package com.project.dmcapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.Doctor;
import com.project.dmcapp.model.Patient;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	
	@Query("Select d from Doctor Where docId= ?1 AND password =?2")
	public Optional<Doctor> findByIdAndPassword(int userId,String password);
}
