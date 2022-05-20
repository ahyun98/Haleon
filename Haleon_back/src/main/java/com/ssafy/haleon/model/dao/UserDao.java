package com.ssafy.haleon.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.User;

public interface UserDao {
	void insertUser(User user);
	User selectById(String id);
	List<User> routineSelectList(HashMap<String, String> params);
	void routineUpdateBoard(User user);
}
