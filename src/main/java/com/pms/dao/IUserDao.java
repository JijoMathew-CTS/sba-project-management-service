package com.pms.dao;

import java.util.List;

import com.pms.entity.User;

public interface IUserDao {
	
	public Integer saveOrUpdate(User user);
	public User getUser(Integer id);
	public List<User> view();
	public Integer delete(Integer id);
	public User getUserByProjectId(Integer projectId);
}
