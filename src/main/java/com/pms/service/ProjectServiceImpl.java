package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.IProjectDao;
import com.pms.entity.Project;

@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private IProjectDao projectDao;

	@Override
	public Integer saveOrUpadte(Project project) {
		Integer saveOrUpadte = projectDao.saveOrUpadte(project);
		return saveOrUpadte;
	}
	
	@Override
	public Project getProject(Integer id) {
		return projectDao.getProject(id);
	}

	@Override
	public List<Project> view() {
		return projectDao.view();
	}

	@Override
	public Integer delete(Integer id) {
		return projectDao.delete(id);
	}
	
}
