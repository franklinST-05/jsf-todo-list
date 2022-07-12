package com.silva.ToDoList.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.silva.ToDoList.dao.GenericDao;
import com.silva.ToDoList.entity.TaskEntity;

@ManagedBean(name = "taskBean")
public class TaskBean {
	private TaskEntity taskEntity = new TaskEntity();
	private GenericDao<TaskEntity> dao = new GenericDao<>();
	
	private List<TaskEntity> tasks = loadResultList();
	private Integer quantityTasks = loadQuantityTask();
	
	
//	methods

	public String save() {
		dao.save(taskEntity);
		taskEntity = new TaskEntity();
		loadResultList();

		return "";
	}

	public String merge() {
		dao.merge(taskEntity);
		taskEntity = new TaskEntity();
		loadResultList();

		return "";
	}
	
	public String delete() {
		dao.deleteById(taskEntity);
		loadResultList();
		return "";
	}
	
	private List<TaskEntity> loadResultList() {
		tasks = dao.getAllResultList(TaskEntity.class);
		loadQuantityTask();
		return tasks;
	}
	
	private Integer loadQuantityTask() {
		quantityTasks = tasks.size();
		
		return quantityTasks;
	}

	public String getCurrentDateFormat() {
		Date date = new Date();
		String[] week = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday" };
		String[] month = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		
		String dateFormated = (week[date.getDay()]) + ", " + date.getDate() + " " + month[date.getMonth()];
		
		return dateFormated;
	}

//	getters and setters

	public TaskEntity getTaskEntity() {
		return taskEntity;
	}

	public void setTaskEntity(TaskEntity taskEntity) {
		this.taskEntity = taskEntity;
	}

	public List<TaskEntity> getTasks() {
		return tasks;
	}

	public Integer getQuantityTasks() {
		return quantityTasks;
	}

	public void setQuantityTasks(Integer quantityTasks) {
		this.quantityTasks = quantityTasks;
	}


}
