package com.rest.service;

import java.util.List;

import com.rest.bean.User;
import com.rest.dao.UserDao;


public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public void insert(User user) {
		userDao.insert(user);
	}
	
	public void deleteById(Integer id) {
		userDao.deleteById(id);
	}
	
	public User selectById(Integer id) {
		return userDao.selectById(id);
	}
	
	public List<User> selectUsers(){
		return userDao.selectUsers();
	}
	
}
