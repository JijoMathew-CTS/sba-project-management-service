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
import com.pms.entity.Task;
import com.pms.service.IParentTaskService;
import com.pms.service.ITaskService;


@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest  {

	@InjectMocks
	private TaskController taskController;

	@Mock
	private ITaskService taskService;
	
	@Mock
	private IParentTaskService parentTaskService;
	
	@Test
	public void createOrUpdateTest() {
		Task task = new Task();
		Integer one = 1;
		when(taskService.saveOrUpdate(Matchers.any(Task.class))).thenReturn(one);
		Integer result = taskController.createOrUpdate(task);
		assertEquals(one,result);
	}
	
	@Test
	public void getTaskTest() {
		String taskId = "1";
		Task task = new Task();
		task.setId(1);
		when(taskService.getTask(Integer.parseInt(taskId))).thenReturn(task);
		Task taskReturn = taskController.getTask(taskId);
		assertEquals(task.getId(), taskReturn.getId());
	}
	
	@Test
	public void getAllTasksTest() {
		List<Task>  taskList = taskController.getAllTasks();
		assertNotNull(taskList);
	}
	
	@Test
	public void getAllParentTasksTest() {
		List<ParentTask>  taskList = taskController.getAllParentTasks();
		assertNotNull(taskList);
	}
	
	@Test
	public void deleteTaskTest() {
		String taskId = "1";
		when(taskService.delete(Integer.parseInt(taskId))).thenReturn(1);
		Integer count = taskController.deleteTask(taskId);
		assertEquals(count , Integer.valueOf(taskId));
	}
	
}