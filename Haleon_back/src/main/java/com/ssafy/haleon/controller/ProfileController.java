package com.ssafy.haleon.controller;

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
import com.ssafy.haleon.model.service.ProfileService;

@RestController
@RequestMapping("/api")
public class ProfileController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ProfileService profileService;

	// 프로필 등록
	@PostMapping("/profile")
	public ResponseEntity<Profile> write(Profile profile) {
		profileService.writeProfile(profile);
		return new ResponseEntity<Profile>(HttpStatus.CREATED);
	}

	// 프로필 가져오기
	@GetMapping("/profile/{id}")
	public ResponseEntity<Profile> read(@PathVariable String id){
		
		try {return new ResponseEntity<Profile>(profileService.selectOne(id), HttpStatus.OK);}
		catch(Exception e){
			throw new ProfileNotFoundException(id +"프로필 없음");
		}
	}

	// 프로필 수정
	@PutMapping("/profile")
	public ResponseEntity<String> modify(Profile profile) {
		profileService.modifyProfile(profile);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
}
