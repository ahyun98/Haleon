package com.ssafy.haleon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<String> join(User user) throws Exception {
		if (user != null) {
			// Dao단에서 user 중복 체크가 이루어짐. 여기서 그래서 따로 안함
			User u = user;
			String jwtPw = jwtUtil.createToken("pw", user.getPw());
			u.setId(u.getId());
			u.setPw(jwtPw);
			u.setUsername(user.getUsername());
			u.setGender(user.getGender());
			userService.join(u);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	// 로그인 기능 (회원 조회)
	@PostMapping("/login")
	public ResponseEntity<String> login(String id, String pw) throws Exception {
		User u = userService.selectUserById(id);
		String jwtPw = jwtUtil.createToken("pw", pw);

		if (u.getPw().equals(jwtPw)) {
			return new ResponseEntity<String>(jwtUtil.createToken("access-token", id),HttpStatus.OK);
		} else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	//유저 id로 가져오기
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id){
		return new ResponseEntity<User>(userService.selectUserById(id), HttpStatus.OK);
	}
}
