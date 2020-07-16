package com.pms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pms.entity.Project;
import com.pms.entity.User;
import com.pms.service.IProjectService;
import com.pms.service.ITaskService;
import com.pms.service.IUserService;


@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest  {

	@InjectMocks
	private ProjectController projectController;

	@Mock
	private  IProjectService projectService;
	
	@Mock
	private ITaskService taskService;
	
	@Mock
	private IUserService userService;
	
	@Test
	public void createOrUpdateTest() {
		Project project = new Project();
		when(projectService.saveOrUpdate(Matchers.any(Project.class))).thenReturn(1);
		projectController.createOrUpdate(project);
		assertNotNull(project);
	}
	
	@Test
	public void getProjectTest() {
		String projectId = "1";
		Project project = new Project();
		project.setId(1);
		when(projectService.getProject(Integer.parseInt(projectId))).thenReturn(project);
		Project projectReturn = projectController.getProject(projectId);
		assertEquals(project.getId(), projectReturn.getId());
	}
	
	@Test
	public void getAllProjectsTest() {
		List<Project> projects =  new ArrayList<>();
		Project project = new Project();
		project.setProject("PROJECT1");
		project.setId(1);
		projects.add(project);
		when(projectService.view()).thenReturn(projects);	
		User user = new User();
		when(userService.getUserByProjectId(project.getId())).thenReturn(user);	
		List<Project>  projectsList = projectController.getAllProjects();
		assertNotNull(projectsList);
	}
	
	@Test
	public void deleteProjectTest() {
		String projectId = "1";
		when(projectService.delete(Integer.parseInt(projectId))).thenReturn(1);
		Integer count = projectController.deleteProject(projectId);
		assertEquals(count , Integer.valueOf(projectId));
	}
	
}