package com.pms.entity;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectTest {

	@InjectMocks
	private Project project;

	@Test
	public void testProjectTest() {
		Date currentDate = new Date();
		project.setId(1);
		project.setEndDate(currentDate);
		project.setPriority(1);
		project.setProject("HQM");
		project.setStartDate(currentDate);
		project.setNoOfCompletedTask(10);
		project.setNoOfTasks(15);
		project.setManager(new Manager());
		project.getEndDate();
		project.getId();
		project.getPriority();
		project.getProject();
		project.getStartDate();
		project.getNoOfCompletedTask();
		project.getNoOfTasks();
		project.getManager();
	}
	
}
