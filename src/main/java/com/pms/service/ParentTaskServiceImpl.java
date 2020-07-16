package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.IParentTaskDao;
import com.pms.entity.ParentTask;

@Service("parentTaskService")
public class ParentTaskServiceImpl implements IParentTaskService {
	
	@Autowired
	private IParentTaskDao parentTaskDao;

	@Override
	public Integer saveOrUpdate(ParentTask parentTask) {
		return parentTaskDao.saveOrUpdate(parentTask);
		}

	@Override
	public ParentTask getParentTask(Integer id) {
		return parentTaskDao.getParentTask(id);
		}

	@Override
	public List<ParentTask> view() {
		return parentTaskDao.view();
		}

	@Override
	public Integer delete(Integer id) {
		return parentTaskDao.delete(id);
		}

}
