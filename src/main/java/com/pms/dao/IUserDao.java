package com.pms.dao;

import java.util.List;

import com.pms.entity.User;

public interface IUserDao {
	
	public Integer saveOrUpadte(User user);
	public User getUser(Integer id);
	public List<User> view();
	public Integer delete(Integer id);
}
