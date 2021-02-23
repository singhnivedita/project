package com.project.dmcapp.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.dmcapp.entities.Patient;

public interface PatientRepo extends CrudRepository<Patient, Integer> {

}
