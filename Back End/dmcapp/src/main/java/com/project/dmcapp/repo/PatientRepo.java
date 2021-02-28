package com.project.dmcapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	
	
	@Query(value = "select* from patient_table Inner Join role_table on patient_table.roleId = role_table.roleId AND role_table.roleName: roleName", nativeQuery = true)
	public List<Patient> findPatientByRoleName(String roleName);
	
	@Query("Select p from Patient p Where patientId= ?1 AND password =?2")
	public Optional<Patient> findByIdAndPassword(int userId,String password);
	

	
}	
