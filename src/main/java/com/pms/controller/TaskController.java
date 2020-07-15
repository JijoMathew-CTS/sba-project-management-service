/**
 * 
 */
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

import com.pms.entity.ParentTask;
import com.pms.entity.Task;
import com.pms.service.IParentTaskService;
import com.pms.service.ITaskService;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private  IParentTaskService parentTaskService;

	@PostMapping("/task/saveorupdate")
	public Integer createOrUpdate(@RequestBody Task task) {
		return taskService.saveOrUpadte(task);
	}
	
	@GetMapping("/task/getTask/{id}")
	public Task getTask(@PathVariable String id) {
		return taskService.getTask(Integer.parseInt(id));
		
		
	}
	
	@GetMapping("/task/getAllTasks")
	public List<Task> getAllTasks(){
		return taskService.view();
		
	}
	
	@GetMapping("/task/getAllParentTasks")
	public List<ParentTask> getAllParentTasks(){
		return parentTaskService.view();
		
	}
	
	@DeleteMapping("/task/delete/{id}")
	public Integer deleteTask(@PathVariable String id) {
		return taskService.delete(Integer.parseInt(id));
	}
	
}
