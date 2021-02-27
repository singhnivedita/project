package com.project.dmcapp.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestResultTest {

	@Test
	public void testSetTestResultId() throws NoSuchFieldException, IllegalAccessException  {
		
        final TestResult testResult = new TestResult();
        testResult.setTestId(1);
        final Field field = testResult.getClass().getDeclaredField("testId");
        field.setAccessible(true);
        assertEquals(field.get(testResult), 1);
        //assertEquals(, field.get(testResult), 01);
	}
	
	@Test
	public void testGetTestResultId() throws NoSuchFieldException, IllegalAccessException  {
		
        final TestResult testResult = new TestResult();
        final Field field = testResult.getClass().getDeclaredField("testId");
        field.setAccessible(true);
        field.set(testResult, 1);
        assertEquals(testResult.getTestId(), 1);
        //assertEquals(,admin.getTestId(), 01);
	}
	
	
	
	@Test
	public void testSetTestName() throws NoSuchFieldException, IllegalAccessException  {
		
        final TestResult testResult = new TestResult();
        testResult.setTestName("Radiology");
        final Field field = testResult.getClass().getDeclaredField("testName");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(testResult), "Radiology");
        //assertEquals("Setter failed", field.get(testResult), "Pathalogy");
	}
	
	
	@Test
	public void testGetTestName() throws NoSuchFieldException, IllegalAccessException  {
		
        final TestResult testResult = new TestResult();
        final Field field = testResult.getClass().getDeclaredField("testName");
        field.setAccessible(true);
        field.set(testResult, "Radiology");
        assertEquals("Getter passed",testResult.getTestName(), "Radiology");
        //assertEquals("Getter failed",doctor.getRoleName(), "Pathalogy");
	}
	
	@Test
	public void testGetTestResult() throws NoSuchFieldException, IllegalAccessException  {
		
        final TestResult testResult = new TestResult();
        final Field field = testResult.getClass().getDeclaredField("testResult");
        field.setAccessible(true);
        field.set(testResult, "Negative");
        assertEquals("Getter passed",testResult.getTestResult(), "Radiology");
        //assertEquals("Getter failed",doctor.getRoleName(), "Negativec");
	}
	
	
	@Test
	public void testSetTestResult() throws NoSuchFieldException, IllegalAccessException  {
		
        final TestResult testResult = new TestResult();
        testResult.setTestName("Negative");
        final Field field = testResult.getClass().getDeclaredField("testResult");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(testResult), "Negative");
        //assertEquals("Setter failed", field.get(testResult), "Negatived");
	}

}