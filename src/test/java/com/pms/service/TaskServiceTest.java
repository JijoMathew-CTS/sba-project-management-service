package com.pms.service;

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

import com.pms.dao.ITaskDao;
import com.pms.entity.Task;


@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest  {

	@InjectMocks
	private TaskServiceImpl taskService;

	@Mock
	private ITaskDao taskDao;
	
	Integer taskId = 1;
	
	Integer projectId = 100;
	
	@Test
	public void createOrUpdateTest() {
		Task task = new Task();
		Integer one = 1;
		when(taskDao.saveOrUpdate(Matchers.any(Task.class))).thenReturn(one);
		Integer result = taskService.saveOrUpdate(task);
		assertEquals(one,result);
	}
	
	@Test
	public void getTaskTest() {
		
		Task task = new Task();
		task.setId(1);
		when(taskDao.getTask(taskId)).thenReturn(task);
		Task taskReturn = taskService.getTask(taskId);
		assertEquals(task.getId(), taskReturn.getId());
	}
	
	@Test
	public void getAllTasksTest() {
		List<Task>  taskList = taskService.view();
		assertNotNull(taskList);
	}
	
	
	@Test
	public void deleteTaskTest() {
		when(taskDao.delete(taskId)).thenReturn(1);
		Integer count = taskService.delete(taskId);
		assertEquals(count , Integer.valueOf(taskId));
	}
	
	@Test
	public void getCompletedTaskByProjectIdTest() {
		when(taskDao.getCompletedTaskByProjectId(projectId)).thenReturn(100);
		Integer count = taskService.getCompletedTaskByProjectId(projectId);
		assertNotNull(count);
	}
	@Test
	public void getTotalTaskByProjectIdTest() {
		when(taskDao.getTotalTaskByProjectId(projectId)).thenReturn(50);
		Integer count = taskService.getTotalTaskByProjectId(projectId);
		assertNotNull(count);
	}
}