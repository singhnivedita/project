package com.project.dmcapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class UpdateCommissionTest {
	
	
	
	
	@Test
	public void testSetCommissionId() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateCommission updateCommission = new UpdateCommission();
        updateCommission.setCommissionId(1);
        final Field field = updateCommission.getClass().getDeclaredField("commissionId");
        field.setAccessible(true);
        assertEquals(field.get(updateCommission), 1);
        //assertEquals(updateCommission.get(updateCommission), 01);
	}
	
	@Test
	public void testGetCommissionId() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateCommission updateCommission = new UpdateCommission();
        final Field field = updateCommission.getClass().getDeclaredField("commissionId");
        field.setAccessible(true);
        field.set(updateCommission, 1);
        assertEquals(updateCommission.getCommissionId(), 1);
        //assertEquals(updateCommission.getCommissionId(), 01);
	}
	
	
	
	@Test
	public void testSetBaselineValue() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateCommission updateCommission = new UpdateCommission();
        updateCommission.setBaselineValue(1);
        final Field field = updateCommission.getClass().getDeclaredField("baselineValue");
        field.setAccessible(true);
        assertEquals(field.get(updateCommission), 1);
        //assertEquals(updateCommission.get(updateCommission), 01);
	}
	
	@Test
	public void testGetBaselineValue() throws NoSuchFieldException, IllegalAccessException  {
		
        final UpdateCommission updateCommission = new UpdateCommission();
        final Field field = updateCommission.getClass().getDeclaredField("baselineValue");
        field.setAccessible(true);
        field.set(updateCommission, 1);
        assertEquals(updateCommission.getBaselineValue(), 1);
        //assertEquals(updateCommission.getCommissionId(), 01);
	}
}
