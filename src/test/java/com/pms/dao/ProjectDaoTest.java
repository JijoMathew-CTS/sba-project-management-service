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

import com.pms.entity.Project;


@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoTest  {

	@InjectMocks
	private ProjectDaoImpl projectDao;

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
	CriteriaQuery<Project> createQuery;
	
	@Mock
	Query<Project> query;
	
	Integer projectId = 1;
	
	@Before
	public void init() {
		when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
		when(sessionFactory.openSession()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(beginTransaction);
		when(session.getCriteriaBuilder()).thenReturn(cb);		
		when(cb.createQuery(Project.class)).thenReturn(createQuery);
		when(cb.createQuery(Project.class)).thenReturn(createQuery);
		when(session.createQuery(createQuery)).thenReturn(query);
	}
	
	@Test
	public void createOrUpdateTest() {
		Project project = new Project();
		project.setId(projectId);
		projectDao.saveOrUpdate(project);
	}
	
	@Test
	public void getProjectTest() {
	
		Project project = new Project();
		project.setId(projectId);
		projectDao.getProject(projectId);
	}
	
	@Test
	public void getAllParentTaskTest() {
		List<Project>  taskList = projectDao.view();
		assertNotNull(taskList);
	}
	
	@Test
	public void deleteProjectTest() {
		projectDao.delete(projectId);
	}
	
}