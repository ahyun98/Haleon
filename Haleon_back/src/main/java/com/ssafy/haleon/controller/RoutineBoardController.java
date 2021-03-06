package com.ssafy.haleon.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.haleon.exception.BoardNotFoundException;
import com.ssafy.haleon.model.dto.CommunityBoard;
import com.ssafy.haleon.model.dto.Profile;
import com.ssafy.haleon.model.dto.RoutineBoard;
import com.ssafy.haleon.model.service.ProfileService;
import com.ssafy.haleon.model.service.RoutineBoardService;

@RestController
@RequestMapping("/api")
public class RoutineBoardController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private RoutineBoardService boardService;

	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/routine")
	public ResponseEntity<RoutineBoard> detail(
			@RequestParam(defaultValue = "") String id,
			@RequestParam(defaultValue = "") String regDate) {

		int period = boardService.routineCnt(id);
		Profile profile = profileService.selectOne(id);
		profile.setPeriod(period);
		profileService.modifyProfile(profile);
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("regDate", regDate);
		return new ResponseEntity<RoutineBoard>(boardService.routineGetBoard(params), HttpStatus.OK);
	}
	
	@PostMapping("/routine")
	public ResponseEntity<String> insert(RoutineBoard routineBoard){
		String curId = routineBoard.getId();
		String curRegDate = routineBoard.getRegDate();
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", curId);
		params.put("regDate", curRegDate);
		RoutineBoard curRoutine = boardService.routineGetBoard(params);
		
		if(curRoutine == null) {
			boardService.routineWriteBoard(routineBoard);
			
			return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Already registered", HttpStatus.OK);
		
	}
	
	@GetMapping("/routine/{id}")
	public ResponseEntity<List<RoutineBoard>> list(String id) {
		return new ResponseEntity<List<RoutineBoard>>(boardService.routineGetBoardList(id), HttpStatus.OK);
	}
	
	@PutMapping("/routine")
	public ResponseEntity<String> modify(RoutineBoard routineBoard){
		boardService.routineModifyBoard(routineBoard);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@GetMapping("/routineCnt/{id}")
	public ResponseEntity<Integer> count(@PathVariable String id){
		return new ResponseEntity<Integer>(boardService.routineCnt(id), HttpStatus.OK);
	}
	
}






