package com.pms.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ManagerTest {

	@InjectMocks
	private Manager manager;

	@Test
	public void testManagerTest() {
		manager.setId(1);
		manager.setEmployeeId("Emp1");
		manager.setFirstName("Jijo");
		manager.setLastName("Mathew");
		manager.getId();
		manager.getEmployeeId();
		manager.getFirstName();
		manager.getLastName();
	}
	
}
