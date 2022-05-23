package com.ssafy.haleon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.haleon.model.dto.User;
import com.ssafy.haleon.model.service.UserService;
import com.ssafy.haleon.util.JWTUtil;
@RestController
@RequestMapping("/api")
public class UserController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	// 회원 등록
	@PostMapping("/user")
	public ResponseEntity<User> join(User user) throws Exception{
		if(user != null) {
			//Dao단에서 user 중복 체크가 이루어짐. 여기서 그래서 따로 안함
			User u = user;
			String jwtPw = jwtUtil.createToken("pw", user.getPw());
			u.setId(u.getId());
			u.setPw(jwtPw);
			userService.join(u);
			return new ResponseEntity<User>(HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	// 로그인 기능 (회원 조회)
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) throws Exception{
		
		User u = userService.login(user.getId(), user.getPw());
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
}
