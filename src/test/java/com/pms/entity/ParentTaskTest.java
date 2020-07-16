package com.pms.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParentTaskTest {

	@InjectMocks
	private ParentTask parentTask;

	@Test
	public void testParentTask() {
		parentTask.setId(1);
		parentTask.setParentTask("Task1");
		parentTask.getId();
		parentTask.getParentTask();
	}
	
}
