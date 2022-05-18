package com.ssafy.haleon.model.service;

import com.ssafy.haleon.model.dto.User;

public interface UserService {
	void join(User user);
	User login(String id, String pw);
}
