package com.pms.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pms.entity.Task;


@RunWith(MockitoJUnitRunner.class)
public class TaskDaoTest  {

	@InjectMocks
	private TaskDaoImpl taskDao;

	@Mock
	private EntityManagerFactory entityManagerFactory;
	
	@Mock
	private Session session;
	
	@Mock
	private CriteriaBuilder cb;
	
	@Mock
	SessionFactory sessionFactory;
	
	@Mock
	private Transaction beginTransaction;
	
	@Mock
	CriteriaQuery<Task> createQuery;
	
	@Mock
	Query<Task> query;
	
	@Mock
	Root<Task> root;
	
	@Mock
	NativeQuery nativeQuery;
	
	Integer taskId = 1;
	
	Integer projectId = 100;
	
	@Before
	public void init() {
		when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
		when(sessionFactory.openSession()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(beginTransaction);
		when(session.getCriteriaBuilder()).thenReturn(cb);		
		when(cb.createQuery(Task.class)).thenReturn(createQuery);
		when(cb.createQuery(Task.class)).thenReturn(createQuery);
		when(session.createQuery(createQuery)).thenReturn(query);
		when(createQuery.from(Task.class)).thenReturn(root);
		when(session.createNativeQuery(Matchers.anyString())).thenReturn(nativeQuery);
		when(nativeQuery.setParameter(Matchers.anyString(), Matchers.anyInt())).thenReturn(nativeQuery);
		
	}
	
	@Test
	public void createOrUpdateTest() {
		Task task = new Task();
		task.setId(taskId);
		taskDao.saveOrUpdate(task);
	}
	
	@Test
	public void getTaskTest() {
	
		Task task = new Task();
		task.setId(taskId);
		taskDao.getTask(taskId);
	}
	
	@Test
	public void getAllTaskTest() {
		List<Task>  taskList = taskDao.view();
		assertNotNull(taskList);
	}
	
	@Test
	public void deleteTaskTest() {
		taskDao.delete(taskId);
	}
	
	
	@Test
	public void getCompletedTaskByProjectIdTest() {
		taskDao.getCompletedTaskByProjectId(projectId);
	}
	
	@Test
	public void getTotalTaskByProjectIdTest() {
		taskDao.getTotalTaskByProjectId(projectId);
	}
}