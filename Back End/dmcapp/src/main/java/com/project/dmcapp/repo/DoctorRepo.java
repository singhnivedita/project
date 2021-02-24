package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.entities.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
