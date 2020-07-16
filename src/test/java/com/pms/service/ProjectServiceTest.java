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

import com.pms.dao.IProjectDao;
import com.pms.entity.Project;


@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest  {

	@InjectMocks
	private  ProjectServiceImpl projectService;

	@Mock
	private IProjectDao projectDao;
	
	Integer projectId = 1;
	
	@Test
	public void createOrUpdateTest() {
		Project project = new Project();
		project.setId(projectId);
		when(projectDao.saveOrUpdate(Matchers.any(Project.class))).thenReturn(1);
		projectService.saveOrUpdate(project);
		assertNotNull(project);
	}
	
	@Test
	public void getProjectTest() {		
		Project project = new Project();
		project.setId(projectId);
		when(projectDao.getProject(projectId)).thenReturn(project);
		Project projectReturn = projectService.getProject(projectId);
		assertEquals(project.getId(), projectReturn.getId());
	}
	
	@Test
	public void getAllProjectsTest() {
		List<Project>  projectsList = projectService.view();
		assertNotNull(projectsList);
	}
	
	@Test
	public void deleteProjectTest() {
		when(projectDao.delete(projectId)).thenReturn(1);
		Integer count = projectService.delete(projectId);
		assertEquals(count , Integer.valueOf(projectId));
	}
	
}