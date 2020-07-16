package com.pms.service;

import java.util.List;

import com.pms.entity.ParentTask;

public interface IParentTaskService {

	public Integer saveOrUpdate(ParentTask parentTask);
	public ParentTask getParentTask(Integer id);
	public List<ParentTask> view();
	public Integer delete(Integer id);
}
