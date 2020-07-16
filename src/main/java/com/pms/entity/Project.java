package com.pms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="project")
public class Project {

	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="project")
	private String project;
	
	@Column(name ="start_dt")
	private Date startDate;
	
	@Column(name="end_dt")
	private Date endDate;
	
	@Column(name="priority")
	private Integer priority;

	@Transient
	private Integer noOfTasks = 0;
	
	@Transient
	private Integer noOfCompletedTask = 0;
	
	@Transient
	private Manager manager;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getNoOfTasks() {
		return noOfTasks;
	}

	public void setNoOfTasks(Integer noOfTasks) {
		this.noOfTasks = noOfTasks;
	}

	public Integer getNoOfCompletedTask() {
		return noOfCompletedTask;
	}

	public void setNoOfCompletedTask(Integer noOfCompletedTask) {
		this.noOfCompletedTask = noOfCompletedTask;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	
	
}
