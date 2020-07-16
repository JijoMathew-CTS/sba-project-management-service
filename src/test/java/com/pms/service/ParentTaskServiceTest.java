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

import com.pms.dao.IParentTaskDao;
import com.pms.entity.ParentTask;


@RunWith(MockitoJUnitRunner.class)
public class ParentTaskServiceTest  {

	@InjectMocks
	private ParentTaskServiceImpl parentTaskService;

	@Mock
	private IParentTaskDao parentTaskDao;
	
	@Test
	public void createOrUpdateTest() {
		ParentTask parentTask = new ParentTask();
		Integer result  = 1;
		when(parentTaskDao.saveOrUpdate(Matchers.any(ParentTask.class))).thenReturn(1);
		Integer count = parentTaskService.saveOrUpdate(parentTask);
		assertEquals(count, result);
	}
	
	@Test
	public void getTaskTest() {
		Integer taskId = 1;
		ParentTask parentTask = new ParentTask();
		parentTask.setId(1);
		when(parentTaskDao.getParentTask(taskId)).thenReturn(parentTask);
		ParentTask parentTaskReturn = parentTaskService.getParentTask(taskId);
		assertEquals(parentTask.getId(), parentTaskReturn.getId());
	}
	
	@Test
	public void getAllParentTaskTest() {
		List<ParentTask>  taskList = parentTaskService.view();
		assertNotNull(taskList);
	}
	
	@Test
	public void deleteTaskTest() {
		Integer taskId = 1;
		when(parentTaskDao.delete(taskId)).thenReturn(1);
		Integer count = parentTaskService.delete(taskId);
		assertEquals(count , Integer.valueOf(taskId));
	}
	
}