package com.ssafy.haleon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.haleon.exception.ProfileNotFoundException;
import com.ssafy.haleon.model.dto.Profile;
import com.ssafy.haleon.model.dto.RoutineBoard;
import com.ssafy.haleon.model.dto.User;
import com.ssafy.haleon.model.service.ProfileService;
import com.ssafy.haleon.model.service.RoutineBoardService;
import com.ssafy.haleon.model.service.UserService;

@RestController
@RequestMapping("/api")
public class ProfileController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoutineBoardService routineBoard;
	
	// 프로필 등록
	@PostMapping("/profile")
	public ResponseEntity<String> write(Profile profile) {
		profileService.writeProfile(profile);
		return new ResponseEntity<String>(SUCCESS,HttpStatus.CREATED);
	}

	// 프로필 가져오기
	@GetMapping("/profile/{id}")
	public ResponseEntity<Profile> read(@PathVariable String id){
		
		try {
			int period = routineBoard.routineCnt(id);
			Profile profile = profileService.selectOne(id);
			profile.setPeriod(period);
			profileService.modifyProfile(profile);
			return new ResponseEntity<Profile>(profileService.selectOne(id), HttpStatus.OK);}
		catch(Exception e){
			throw new ProfileNotFoundException(id +"프로필 없음");
		}
	}
	
	//모든 유저의 프로필 가져오기
	@GetMapping("/profileList")
	public ResponseEntity<List<Profile>> profileList(){
		return new ResponseEntity<List<Profile>>(profileService.selectList(), HttpStatus.OK);
	}
	//모든 유저의 프로필 가져오기 출석도 순으로
	@GetMapping("/profileListPeriod")
	public ResponseEntity<List<Profile>> profileListPeriod(){
		return new ResponseEntity<List<Profile>>(profileService.selectListPeriod(), HttpStatus.OK);
	}
	//모든 유저의 프로필 가져오기 근육량 순으로
	@GetMapping("/profileListMuscle")
	public ResponseEntity<List<Profile>> profileListMuscle(){
		return new ResponseEntity<List<Profile>>(profileService.selectListMuscle(), HttpStatus.OK);
	}
	
	// 프로필 수정
	@PutMapping("/profile")
	public ResponseEntity<String> modify(Profile profile) {
		profileService.modifyProfile(profile);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	//프로필에 해당하는 유저 정보 가져오기
	@GetMapping("/profileUser/{id}")
	public ResponseEntity<String> profileUser(@PathVariable String id){
		User u = userService.selectUserById(id);
		return new ResponseEntity<String>(u.getUsername(), HttpStatus.OK);
	}
}
