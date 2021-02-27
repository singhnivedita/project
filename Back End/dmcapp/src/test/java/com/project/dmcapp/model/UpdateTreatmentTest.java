package com.project.dmcapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class UpdateTreatmentTest {
	@Test
	public void testSetTreatmentId() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateTreatment updateTreatment = new UpdateTreatment();
        updateTreatment.setTreatmentId(1);
        final Field field = updateTreatment.getClass().getDeclaredField("treatmentId");
        field.setAccessible(true);
        assertEquals(field.get(updateTreatment), 1);
        //assertEquals(updateTreatment.get(updateTreatment), 01);
	}
	
	@Test
	public void testGetTreatmentId() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateTreatment updateTreatment = new UpdateTreatment();
        final Field field = updateTreatment.getClass().getDeclaredField("treatmentId");
        field.setAccessible(true);
        field.set(updateTreatment, 1);
        assertEquals(updateTreatment.getTreatmentId(), 1);
        //assertEquals(updateTreatment.updateTreatment(), 01);
	}
	
	
	
	@Test
	public void testSetsymptoms() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateTreatment updateTreatment = new UpdateTreatment();
        updateTreatment.setTreatmentId(1);
        final Field field = updateTreatment.getClass().getDeclaredField("symptoms");
        field.setAccessible(true);
        assertEquals(field.get(updateTreatment), 1);
        //assertEquals(updateTreatment.get(updateTreatment), 01);
	}
	
	@Test
	public void testGetSymptoms() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateTreatment updateTreatment = new UpdateTreatment();
        final Field field = updateTreatment.getClass().getDeclaredField("symptoms");
        field.setAccessible(true);
        field.set(updateTreatment, 1);
        assertEquals(updateTreatment.getTreatmentId(), 1);
        //assertEquals(updateTreatment.updateTreatment(), 01);
	}
}
