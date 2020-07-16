package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.ITaskDao;
import com.pms.entity.Task;

@Service("taskService")
public class TaskServiceImpl implements ITaskService {

	@Autowired
	private ITaskDao taskDao;
	
	@Override
	public Integer saveOrUpdate(Task task) {
		return taskDao.saveOrUpdate(task);
	}

	@Override
	public Task getTask(Integer id) {
		return taskDao.getTask(id);
		}

	@Override
	public List<Task> view() {
		return taskDao.view();
		}

	@Override
	public Integer delete(Integer id) {
		return taskDao.delete(id);
		}

	@Override
	public Integer getCompletedTaskByProjectId(Integer projectId) {
		return taskDao.getCompletedTaskByProjectId(projectId);
	}

	@Override
	public Integer getTotalTaskByProjectId(Integer projectId) {
		return taskDao.getTotalTaskByProjectId(projectId);
	}

}
