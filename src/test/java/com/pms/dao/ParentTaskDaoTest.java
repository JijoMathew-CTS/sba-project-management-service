package com.pms.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pms.entity.ParentTask;


@RunWith(MockitoJUnitRunner.class)
public class ParentTaskDaoTest  {

	@InjectMocks
	private ParentTaskDaoImpl parentTaskDao;

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
	CriteriaQuery<ParentTask> createQuery;
	
	@Mock
	Query<ParentTask> query;
	
	Integer taskId = 1;
	
	@Before
	public void init() {
		when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
		when(sessionFactory.openSession()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(beginTransaction);
		when(session.getCriteriaBuilder()).thenReturn(cb);		
		when(cb.createQuery(ParentTask.class)).thenReturn(createQuery);
		when(cb.createQuery(ParentTask.class)).thenReturn(createQuery);
		when(session.createQuery(createQuery)).thenReturn(query);
	}
	
	@Test
	public void createOrUpdateTest() {
		ParentTask parentTask = new ParentTask();
		parentTask.setId(taskId);
		parentTaskDao.saveOrUpdate(parentTask);
	}
	
	@Test
	public void getTaskTest() {
	
		ParentTask parentTask = new ParentTask();
		parentTask.setId(taskId);
		parentTaskDao.getParentTask(taskId);
	}
	
	@Test
	public void getAllParentTaskTest() {
		List<ParentTask>  taskList = parentTaskDao.view();
		assertNotNull(taskList);
	}
	
	@Test
	public void deleteTaskTest() {
		parentTaskDao.delete(taskId);
	}
	
}