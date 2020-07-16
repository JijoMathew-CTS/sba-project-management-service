package com.pms.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	@InjectMocks
	private User user;

	@Test
	public void testUserTest() {
		user.setId(1);
		user.setEmployeeId("Emp1");
		user.setFirstName("Jijo");
		user.setLastName("Mathew");
		user.setProject(null);
		user.setTask(null);		
		user.getId();
		user.getEmployeeId();
		user.getFirstName();
		user.getLastName();
		user.getProject();
		user.getTask();
	}
	
}
