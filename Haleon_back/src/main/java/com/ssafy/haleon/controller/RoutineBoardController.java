package com.ssafy.haleon.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.haleon.exception.BoardNotFoundException;
import com.ssafy.haleon.model.dto.RoutineBoard;
import com.ssafy.haleon.model.service.RoutineBoardService;

@RestController
@RequestMapping("/api")
public class RoutineBoardController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private RoutineBoardService boardService;

	@GetMapping("/routineBoard")
	public ResponseEntity<List<RoutineBoard>> list(@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<RoutineBoard>>(boardService.routineGetBoardList(params), HttpStatus.OK);
	}
	
	@PostMapping("/routineBoard")
	public ResponseEntity<String> write(RoutineBoard board){
		boardService.routineWriteBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}
	
	@PutMapping("/routineBoard")
	public ResponseEntity<String> update(RoutineBoard board){
		boardService.routineModifyBoard(board); //결과 boolean 이니까 가져다가 써도 좋다.
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@GetMapping("/routineBoard/{num}")
	public ResponseEntity<RoutineBoard> detail(@PathVariable int num) {
		try {
			return new ResponseEntity<RoutineBoard>(boardService.routineGetBoardById(num), HttpStatus.OK);
		}catch (Exception e) {
			throw new BoardNotFoundException(num +"번 게시글은 없습니다.");		
		}
	}
	
	@DeleteMapping("/routineBoard/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		if(boardService.routineDeleteBoard(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}






