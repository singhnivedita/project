package com.project.dmcapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {

	@Test
	public void testSetAdminId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Admin admin = new Admin();
        admin.setAdminId(1);
        final Field field = admin.getClass().getDeclaredField("adminId");
        field.setAccessible(true);
        assertEquals(field.get(admin), 1);
        //assertEquals(, field.get(admin), 01);
	}
	
	@Test
	public void testGetAdminId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Admin admin = new Admin();
        final Field field = admin.getClass().getDeclaredField("adminId");
        field.setAccessible(true);
        field.set(admin, 1);
        assertEquals(admin.getAdminId(), 1);
        //assertEquals(,admin.getAdminId(), 01);
	}
}