package com.project.dmcapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

	@Query(value = "select* from patient_table Inner Join role_table on patient_table.roleId = role_table.roleId AND role_table.roleName: roleName", nativeQuery = true)
	public List<Patient> findPatientByRoleName(String roleName);
}
