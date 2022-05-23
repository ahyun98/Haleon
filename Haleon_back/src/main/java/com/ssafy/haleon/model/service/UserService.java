package com.ssafy.haleon.model.service;

import com.ssafy.haleon.model.dto.User;

public interface UserService {
	void join(User user) throws Exception;
	User login(String id, String pw) throws Exception;
	User selectUserById(String id);
}
