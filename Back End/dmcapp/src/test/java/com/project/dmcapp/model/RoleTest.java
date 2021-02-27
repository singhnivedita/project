package com.project.dmcapp.model;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {

	@Test
	public void testSetRoleId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Role role = new Role();
        role.setRoleId(1);
        final Field field = role.getClass().getDeclaredField("roleId");
        field.setAccessible(true);
        assertEquals(field.get(role), 1);
        //assertEquals(, field.get(role), 01);
	}
	
	@Test
	public void testGetRoleId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Role role = new Role();
        final Field field = role.getClass().getDeclaredField("roleId");
        field.setAccessible(true);
        field.set(role, 1);
        assertEquals(role.getRoleId(), 1);
        //assertEquals(,admin.getRoleId(), 01);
	}
	
	
	
	@Test
	public void testSetRoleName() throws NoSuchFieldException, IllegalAccessException  {
		
        final Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        final Field field = role.getClass().getDeclaredField("roleName");
        field.setAccessible(true);
        assertEquals("Setter passed", field.get(role), "ROLE_ADMIN");
        //assertEquals("Setter failed", field.get(role), "ROLE-ADMIN");
	}
	
	
	@Test
	public void testGetRoleName() throws NoSuchFieldException, IllegalAccessException  {
		
        final Role role = new Role();
        final Field field = role.getClass().getDeclaredField("roleName");
        field.setAccessible(true);
        field.set(role, "ROLE_ADMIN");
        assertEquals("Getter passed",role.getRoleName(), "ROLE_ADMIN");
        //assertEquals("Getter failed",doctor.getRoleName(), "ROLE-ADMIN");
	}
}