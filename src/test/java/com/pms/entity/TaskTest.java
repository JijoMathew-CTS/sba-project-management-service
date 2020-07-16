package com.pms.entity;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaskTest {

	@InjectMocks
	private Task task;

	@Test
	public void testTaskTest() {
		Date currentDate = new Date();
		task.setId(1);
		task.setEndDate(currentDate);
		task.setParentTask(null);
		task.setPriorty(1);
		task.setStartDate(currentDate);
		task.setProject(null);
		task.setStatus(1);
		task.setTask("Task1");
		task.getId();
		task.getEndDate();
		task.getParentTask();
		task.getPriorty();
		task.getStartDate();
		task.getProject();
		task.getStatus();
		task.getTask();
	}
	
}
