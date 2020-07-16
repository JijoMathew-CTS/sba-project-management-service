package com.pms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pms.entity.ParentTask;
import com.pms.service.IParentTaskService;


@RunWith(MockitoJUnitRunner.class)
public class ParentTaskControllerTest  {

	@InjectMocks
	private ParentTaskController parentTaskController;

	@Mock
	private  IParentTaskService parentTaskService;
	
	@Test
	public void createOrUpdateTest() {
		ParentTask parentTask = new ParentTask();
		Integer result  = 1;
		when(parentTaskService.saveOrUpdate(Matchers.any(ParentTask.class))).thenReturn(1);
		Integer count = parentTaskController.createOrUpdate(parentTask);
		assertEquals(count, result);
	}
	
	@Test
	public void getTaskTest() {
		String taskId = "1";
		ParentTask parentTask = new ParentTask();
		parentTask.setId(1);
		when(parentTaskService.getParentTask(Integer.parseInt(taskId))).thenReturn(parentTask);
		ParentTask parentTaskReturn = parentTaskController.getTask(taskId);
		assertEquals(parentTask.getId(), parentTaskReturn.getId());
	}
	
	@Test
	public void getAllParentTaskTest() {
		List<ParentTask>  taskList = parentTaskController.getAllParentTask();
		assertNotNull(taskList);
	}
	
	@Test
	public void deleteTaskTest() {
		String taskId = "1";
		when(parentTaskService.delete(Integer.parseInt(taskId))).thenReturn(1);
		Integer count = parentTaskController.deleteTask(taskId);
		assertEquals(count , Integer.valueOf(taskId));
	}
	
}