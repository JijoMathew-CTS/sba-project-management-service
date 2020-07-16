package com.pms.controller;

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

import com.pms.entity.ParentTask;
import com.pms.entity.Task;
import com.pms.entity.User;
import com.pms.service.IParentTaskService;
import com.pms.service.ITaskService;
import com.pms.service.IUserService;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest  {

	@InjectMocks
	private UserController userController;

	@Mock
	private IUserService userService;
	
	
	@Test
	public void createOrUpdateTest() {
		User  user = new User();
		Integer one = 1;
		when(userService.saveOrUpdate(Matchers.any(User.class))).thenReturn(one);
		Integer result = userController.createOrUpdate(user);
		assertEquals(one,result);
	}
	
	@Test
	public void getTaskTest() {
		String userId = "1";
		User  user = new User();
		user.setId(1);
		when(userService.getUser(Integer.parseInt(userId))).thenReturn(user);
		User userReturn = userController.getUser(userId);
		assertEquals(user.getId(), userReturn.getId());
	}
	
	@Test
	public void getAllUsersTest() {
		List<User> userList = userController.getAllUsers();
		assertNotNull(userList);
	}
	
	
	@Test
	public void deleteUserTest() {
		String userId = "1";
		when(userService.delete(Integer.parseInt(userId))).thenReturn(1);
		Integer count = userController.deleteUser(userId);
		assertEquals(count , Integer.valueOf(userId));
	}
	
}