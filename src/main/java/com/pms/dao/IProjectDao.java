package com.pms.dao;

import java.util.List;

import com.pms.entity.Project;

public interface IProjectDao {

	public Integer saveOrUpadte(Project project);
	public Project getProject(Integer id);
	public List<Project> view();
	public Integer delete(Integer id);
}
