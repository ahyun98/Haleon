package com.ssafy.haleon.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.haleon.model.dto.User;
import com.ssafy.haleon.model.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private UserService userService;
	
	// 회원 가입
	@PostMapping("/join")
	public ResponseEntity<User> join(User user){
		userService.join(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	// 로그인 기능
	@GetMapping("/login")
	public ResponseEntity<User> login(String id, String pw){
		User user = userService.login(id, pw);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
