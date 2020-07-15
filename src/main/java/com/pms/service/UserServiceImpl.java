package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.IUserDao;
import com.pms.entity.User;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public Integer saveOrUpadte(User user) {
		return userDao.saveOrUpadte(user);
	}

	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> view() {
		return userDao.view();
	}

	@Override
	public Integer delete(Integer id) {
		return userDao.delete(id);
	}

}
