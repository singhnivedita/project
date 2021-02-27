package com.project.dmcapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTest {
	
	@Test
	public void testSetPatientId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Patient patient = new Patient();
        patient.setPatientId(100);
        final Field field = patient.getClass().getDeclaredField("patientId");
        field.setAccessible(true);
        assertEquals( field.get(patient), 100);
        //assertEquals( field.get(patient), 100);
	}
	
	@Test
	public void testGetDoctorId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Patient patient = new Patient();
        final Field field = patient.getClass().getDeclaredField("patientId");
        field.setAccessible(true);
        field.set(patient, 100);
        assertEquals(patient.getPatientId(), 100);
        //assertEquals(doctor.getPatientId(), 100);
	}
	
	
}