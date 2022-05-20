package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

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
		if( user == null) // 유저가 없는 경우
			throw new UserNotFoundException();
		else if( !user.getPw().equals(pw)) // 패스워드가 일치하지 않는 경우
			throw new PWIncorrectException();
		else
			return user;
	}

	@Override
	public List<User> getUserList(HashMap<String, String> params) {
		return userDao.getSelectList(params);
	}

}
