package com.project.dmcapp;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.dmcapp.entities.Agent;
import com.project.dmcapp.entities.Doctor;
import com.project.dmcapp.entities.Patient;
import com.project.dmcapp.repo.AgentRepo;
import com.project.dmcapp.repo.DoctorRepo;
import com.project.dmcapp.repo.PatientRepo;

@SpringBootTest
class DmcappApplicationTests {

	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private AgentRepo agentRepo;
	
	
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
		doctor.setContactNumber("6663854425");
		doctor.setAddress("Indore, India");
		doctor.setPassword("doctorpwd");
		doctor.setQualification("MBBBS, MD");
		doctor.setSpeciality("General Physician");
		doctor.setRole("Doctor");
		doctorRepo.save(doctor);

	}
	
	@Test
	public void testCreateAgent() {

		Agent agent = new Agent();
		agent.setAgentId("AG101");
		agent.setFName("Aryan");
		agent.setLName("Singh");
		Date date = null;
		date = Date.valueOf("1984-01-01");
		agent.setDob(date);
		agent.setGender("Male");
		agent.setContactNumber("7763854425");
		agent.setEmail("aryansingh@gmail.com");
		agent.setPassword("agentpwd");
		agent.setBankAccNo("7845236987899");
		agent.setBankName("SBI Bank");
		agent.setIfsc("SBIN00761");
		agent.setRole("Agent");
		agentRepo.save(agent);

	}
	

}
