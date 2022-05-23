package com.ssafy.haleon.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.haleon.exception.LogNotFoundException;
import com.ssafy.haleon.model.dto.VideoLog;
import com.ssafy.haleon.model.service.VideoLogService;

@RestController
@RequestMapping("/api")
public class VideoLogController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	VideoLogService videoLogService;

	@PostMapping("/insertLog")
	public ResponseEntity<String> insertLog(VideoLog videoLog){
		videoLogService.insertVideoLog(videoLog);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); 
	}
	
	@GetMapping("/logList")
	public ResponseEntity<List<VideoLog>> list(
			@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<VideoLog>>(videoLogService.getVideoLogList(params), HttpStatus.OK);
	}
	
	@GetMapping("/logListDesc")
	public ResponseEntity<List<VideoLog>> listDesc(
			@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<VideoLog>>(videoLogService.getVideoLogListDesc(params), HttpStatus.OK);
	}
	
	@GetMapping("/videoLog/{seq}")
	public ResponseEntity<String> deleteLog(@PathVariable int seq){
		videoLogService.deleteVideoLog(seq);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@GetMapping("/getLogBySeq/{seq}")
	public ResponseEntity<VideoLog> getLog(@PathVariable int seq){
		try {
		return new ResponseEntity<VideoLog>(videoLogService.selectOne(seq), HttpStatus.OK);}
		catch (Exception e){
			throw new LogNotFoundException(seq + " : 비디오 없음");
		}
	}
	
	@GetMapping("/getLogByName/{name}")
	public ResponseEntity<VideoLog> getLog(@PathVariable String name){
		try {
		return new ResponseEntity<VideoLog>(videoLogService.selectOneByName(name), HttpStatus.OK);}
		catch (Exception e){
			throw new LogNotFoundException(name + " : 비디오 없음");
		}
	}
	
	
}
