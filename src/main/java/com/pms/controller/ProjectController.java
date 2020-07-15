package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.Project;
import com.pms.service.IProjectService;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
	
	@Autowired
	private IProjectService projectService;
	
	@PostMapping("/project/saveorupdate")
	public void createOrUpdate(@RequestBody Project project) {
		projectService.saveOrUpadte(project);
	}
	
	@GetMapping("/project/getProject/{id}")
	public Project getProject(@PathVariable String id) {
		return projectService.getProject(Integer.parseInt(id));
		
		
	}
	
	@GetMapping("/project/getAllProjects")
	public List<Project> getAllProjects(){
		return projectService.view();
		
	}
	
	@DeleteMapping("/project/delete/{id}")
	public Integer deleteProject(@PathVariable String id) {
		return projectService.delete(Integer.parseInt(id));
	}

}
