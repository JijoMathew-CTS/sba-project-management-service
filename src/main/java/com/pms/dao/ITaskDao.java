package com.pms.dao;

import java.util.List;

import com.pms.entity.Task;

public interface ITaskDao {
	
	public Integer saveOrUpadte(Task task);
	public Task getTask(Integer id);
	public List<Task> view();
	public Integer delete(Integer id);
}
