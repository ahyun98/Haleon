package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.User;

public interface UserService {
	void join(User user) throws Exception;
	User login(String id, String pw) throws Exception;
	List<User>gGetUserList(HashMap<String, String> params);

}
