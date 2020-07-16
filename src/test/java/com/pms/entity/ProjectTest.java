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
		project.getEndDate();
		project.getId();
		project.getPriority();
		project.getProject();
		project.getStartDate();
	}
	
}
