package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.beans.User;
import com.demo.dao.UserDao;

@Component
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User findById(long id){
		return userDao.findById(id);
	}
	
	public User add(User u) {
		return userDao.add(u);
	}
	
	public void delete(long id) {
		userDao.delete(id);
	}
	

}
