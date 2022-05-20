package com.ssafy.haleon.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.exception.PWIncorrectException;
import com.ssafy.haleon.exception.UserNotFoundException;
import com.ssafy.haleon.model.dao.UserDao;
import com.ssafy.haleon.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
		
	@Override
	public void join(User user) {
		String id = user.getId();
		userDao.insertUser(user);
	}

	@Override
	public User login(String id, String pw) throws Exception {
		User user = userDao.selectById(id);
		if( user == null)
			throw new UserNotFoundException();
		else if( !user.getPw().equals(pw))
			throw new PWIncorrectException();
		else
			return user;
	}

}
