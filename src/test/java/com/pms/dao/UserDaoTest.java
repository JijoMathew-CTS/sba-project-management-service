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
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pms.entity.User;


@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest  {

	@InjectMocks
	private UserDaoImpl userDao;

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
	CriteriaQuery<User> createQuery;
	
	@Mock
	Query<User> query;
	
	@Mock
	Root<User> root;
	
	Integer userId = 1;
	
	@Before
	public void init() {
		when(entityManagerFactory.unwrap(SessionFactory.class)).thenReturn(sessionFactory);
		when(sessionFactory.openSession()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(beginTransaction);
		when(session.getCriteriaBuilder()).thenReturn(cb);		
		when(cb.createQuery(User.class)).thenReturn(createQuery);
		when(cb.createQuery(User.class)).thenReturn(createQuery);
		when(session.createQuery(createQuery)).thenReturn(query);
		when(createQuery.from(User.class)).thenReturn(root);
	}
	
	@Test
	public void createOrUpdateTest() {
		User user = new User();
		user.setId(userId);
		userDao.saveOrUpdate(user);
	}
	
	@Test
	public void getUserTest() {
	
		User user = new User();
		user.setId(userId);
		userDao.getUser(userId);
	}
	
	@Test
	public void getAllUserTest() {
		List<User>  taskList = userDao.view();
		assertNotNull(taskList);
	}
	
	@Test
	public void deleteUserTest() {
		userDao.delete(userId);
	}
	
}