package com.project.dmcapp.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.dmcapp.entities.Doctor;

public interface DoctorRepo extends CrudRepository<Doctor, Integer> {

}
