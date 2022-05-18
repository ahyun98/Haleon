package com.ssafy.haleon.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.model.dao.UserDao;
import com.ssafy.haleon.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
		
	@Override
	public void join(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User login(String id, String pw) {
		User user = userDao.selectById(id);
		if(user != null && user.getPw().equals(pw))
			return user;
		else
			return null;
	}

}
