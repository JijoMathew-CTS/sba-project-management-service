package com.pms.dao;

import java.util.List;

import com.pms.entity.ParentTask;


public interface IParentTaskDao {
	public Integer saveOrUpdate(ParentTask parentTask);
	public ParentTask getParentTask(Integer id);
	public List<ParentTask> view();
	public Integer delete(Integer id);
}
