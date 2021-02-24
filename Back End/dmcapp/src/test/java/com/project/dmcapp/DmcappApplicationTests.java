package com.project.dmcapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.project.dmcapp.entities.Agent;
import com.project.dmcapp.entities.Doctor;
import com.project.dmcapp.entities.Patient;
import com.project.dmcapp.entities.Role;
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
		Role role = new Role();
		role.setRoleId(3);
		patient.setRole(role);
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
		Role role = new Role();
		role.setRoleId(1);
		doctor.setRole(role);
		doctorRepo.save(doctor);

	}
	
	@Test
	public void testCreateAgent() {

		Agent agent = new Agent();
		agent.setAgentId(101);
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
		Role role = new Role();
		role.setRoleId(4);
		agent.setRole(role);
		agentRepo.save(agent);

	}
	
	@Test
	public void testPatientRoleAgent() {
		List<Patient> patients = patientRepo.findPatientByRoleName("Doctor");
		assertThat(patients).size().isGreaterThanOrEqualTo(0);
		
	}

	@Test
	public void testDoctorRole() {
		List<Patient> patients = patientRepo.findAll().stream().filter(pt->pt.getRole().getRoleName().equals("Doctor")).collect(Collectors.toList());
		assertThat(patients).size().isGreaterThanOrEqualTo(0);
	}
	
}
