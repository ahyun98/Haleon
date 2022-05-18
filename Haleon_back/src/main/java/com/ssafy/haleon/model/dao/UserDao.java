package com.ssafy.haleon.model.dao;

import com.ssafy.haleon.model.dto.User;

public interface UserDao {
	void insertUser(User user);
	User selectById(String id);
}
