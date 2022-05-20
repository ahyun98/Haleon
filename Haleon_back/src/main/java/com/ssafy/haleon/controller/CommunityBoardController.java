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
import com.ssafy.haleon.model.dto.CommunityBoard;
import com.ssafy.haleon.model.service.CommunityBoardService;

@RestController
@RequestMapping("/api")
public class CommunityBoardController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private CommunityBoardService boardService;
	
	@GetMapping("/communityBoard")
	public ResponseEntity<List<CommunityBoard>> list(
			@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<CommunityBoard>>(boardService.getBoardList(params), HttpStatus.OK);
	}
	
	@PostMapping("/communityBoard")
	public ResponseEntity<String> write(CommunityBoard board){
		boardService.writeBoard(board);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}
	
	@PutMapping("/communityBoard")
	public ResponseEntity<String> update(CommunityBoard board){
		boardService.modifyBoard(board); //결과 boolean 이니까 가져다가 써도 좋다.
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@GetMapping("/communityBoard/{id}")
	public ResponseEntity<CommunityBoard> detail(@PathVariable int id) {
		try {
			return new ResponseEntity<CommunityBoard>(boardService.getBoardById(id), HttpStatus.OK);
		}catch (Exception e) {
			throw new BoardNotFoundException(id +"게시글 없음");		
		}
	}
	
	@DeleteMapping("/communityBoard/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		if(boardService.deleteBoard(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}






