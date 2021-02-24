package com.project.dmcapp;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.dmcapp.entities.Doctor;
import com.project.dmcapp.entities.Patient;
import com.project.dmcapp.repo.DoctorRepo;
import com.project.dmcapp.repo.PatientRepo;

@SpringBootTest
class DmcappApplicationTests {

	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Test
	public void testRegisterPateint() {

		Patient patient = new Patient();
		patient.setFName("Ram");
		patient.setLName("Singh");
		Date date = null;
		date = Date.valueOf("1980-09-01");
		patient.setDob(date);
		patient.setGender("Male");
		patient.setContactNumber("9963854425");
		patient.setAddress("Bhopal, India");
		patient.setPassword("patientpwd");
		patient.setRole("Patient");
		patientRepo.save(patient);

	}
	
	@Test
	public void testRegisterDoctor() {

		Doctor doctor = new Doctor();
		doctor.setFName("Dr. MP");
		doctor.setLName("Singh");
		Date date = null;
		date = Date.valueOf("1984-01-01");
		doctor.setDob(date);
		doctor.setGender("Male");
		doctor.setContactNumber("9963854425");
		doctor.setAddress("Bhopal, India");
		doctor.setPassword("doctorpwd");
		doctor.setQualification("MBBBS, MD");
		doctor.setSpeciality("General Physician");
		doctor.setRole("Doctor");
		doctorRepo.save(doctor);

	}
	

}
