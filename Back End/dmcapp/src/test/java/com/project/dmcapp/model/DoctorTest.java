package com.project.dmcapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DoctorTest {
	
	@Test
	public void testSetDoctorId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Doctor doctor = new Doctor();
        doctor.setDocId(100);
        final Field field = doctor.getClass().getDeclaredField("doctorId");
        field.setAccessible(true);
        assertEquals( field.get(doctor), 100);
        //assertEquals( field.get(doctor), 100);
	}
	
	@Test
	public void testGetDoctorId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Doctor doctor = new Doctor();
        final Field field = doctor.getClass().getDeclaredField("doctorId");
        field.setAccessible(true);
        field.set(doctor, 100);
        assertEquals(doctor.getDocId(), 100);
        //assertEquals(doctor.getDoctorId(), 100);
	}
	
	
	@Test
	public void testSetQualification() throws NoSuchFieldException, IllegalAccessException  {
		
        final Doctor doctor = new Doctor();
        doctor.setQualification("M.D");
        final Field field = doctor.getClass().getDeclaredField("qualification");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(doctor), "M.D");
        //assertEquals("Setter failed", field.get(doctor), "MD");
	}
	
	@Test
	public void testGetQualification() throws NoSuchFieldException, IllegalAccessException  {
		
        final Doctor doctor = new Doctor();
        final Field field = doctor.getClass().getDeclaredField("qualification");
        field.setAccessible(true);
        field.set(doctor, "M.D");
        assertEquals("Getter passed",doctor.getQualification(), "M.D");
        //assertEquals("Getter failed",doctor.getQualification(), "MD");
	}
	@Test
	public void testSetSpecialization() throws NoSuchFieldException, IllegalAccessException  {
		
        final Doctor doctor = new Doctor();
        doctor.setSpeciality("Microbiology");
        final Field field = doctor.getClass().getDeclaredField("speciality");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(doctor), "Microbiology");
        //assertEquals("Setter failed", field.get(doctor), "Virology");
	}
	
	@Test
	public void testGetSpecialization() throws NoSuchFieldException, IllegalAccessException  {
		
        final Doctor doctor = new Doctor();
        final Field field = doctor.getClass().getDeclaredField("specialization");
        field.setAccessible(true);
        field.set(doctor, "Microbiology");
        assertEquals("Getter passed",doctor.getSpeciality(), "Microbiology");
        //assertEquals("Getter failed",doctor.getSpeciality(), "Virology");
	}
}