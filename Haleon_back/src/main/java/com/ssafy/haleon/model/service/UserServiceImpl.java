package com.ssafy.haleon.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.exception.PWIncorrectException;
import com.ssafy.haleon.exception.UserDuplicateException;
import com.ssafy.haleon.exception.UserNotFoundException;
import com.ssafy.haleon.model.dao.UserDao;
import com.ssafy.haleon.model.dto.User;
import com.ssafy.haleon.util.JWTUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private JWTUtil jwtUtil;
		
	@Override
	public void join(User user) {
		//ID 중복 체크
		if(userDao.selectById(user.getId()) == null)
			userDao.insertUser(user);
		else
			new UserDuplicateException();
	}

	@Override
	public User login(String id, String pw) throws Exception {
		User user = userDao.selectById(id);
		String jwtPw = jwtUtil.createToken("pw", pw);
		if( user == null) // 유저가 없는 경우
			throw new UserNotFoundException();
		else if( !user.getPw().equals(jwtPw)) // 패스워드가 일치하지 않는 경우
			throw new PWIncorrectException();
		else
			return user;
	}

	@Override
	public User selectUserById(String id) {
		User user = userDao.selectById(id);
		return user;
	}
}
