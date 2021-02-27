package com.project.dmcapp.model;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgentTest {

	@Test
	public void testSetAdminId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Agent agent = new Agent();
        agent.setAgentId(1);
        final Field field = agent.getClass().getDeclaredField("agentId");
        field.setAccessible(true);
        assertEquals(field.get(agent), 1);
        //assertEquals(, field.get(agent), 01);
	}
	
	@Test
	public void testGetAdminId() throws NoSuchFieldException, IllegalAccessException  {
		
        final Agent agent = new Agent();
        final Field field = agent.getClass().getDeclaredField("agentId");
        field.setAccessible(true);
        field.set(agent, 1);
        assertEquals(agent.getAgentId(), 1);
        //assertEquals(,admin.getAgentId(), 01);
	}
}