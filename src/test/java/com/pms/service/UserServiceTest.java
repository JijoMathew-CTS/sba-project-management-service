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

import com.pms.dao.IUserDao;
import com.pms.entity.User;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest  {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private IUserDao userDao;
	
	Integer userId = 1;
	
	@Test
	public void createOrUpdateTest() {
		User  user = new User();
		Integer one = 1;
		when(userDao.saveOrUpdate(Matchers.any(User.class))).thenReturn(one);
		Integer result = userService.saveOrUpdate(user);
		assertEquals(one,result);
	}
	
	@Test
	public void getUserTest() {
		User  user = new User();
		user.setId(1);
		when(userDao.getUser(userId)).thenReturn(user);
		User userReturn = userService.getUser(userId);
		assertEquals(user.getId(), userReturn.getId());
	}
	
	@Test
	public void getAllUsersTest() {
		List<User> userList = userService.view();
		assertNotNull(userList);
	}
	
	
	@Test
	public void deleteUserTest() {
		when(userDao.delete(userId)).thenReturn(1);
		Integer count = userService.delete(userId);
		assertEquals(count , Integer.valueOf(userId));
	}
	
	@Test
	public void getUserByProjectIdTest() {
		Integer projectId = 100;
		User  user = new User();
		user.setId(1);
		when(userDao.getUserByProjectId(projectId)).thenReturn(user);
		User userReturn = userService.getUserByProjectId(projectId);
		assertEquals(user.getId(), userReturn.getId());
	}
	
}