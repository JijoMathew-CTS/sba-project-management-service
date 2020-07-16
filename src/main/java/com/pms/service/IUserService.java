package com.pms.service;

import java.util.List;

import com.pms.entity.User;

public interface IUserService {
	
	public Integer saveOrUpdate(User user);
	public User getUser(Integer id);
	public List<User> view();
	public Integer delete(Integer id);
}
