package com.ssafy.haleon.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<String> insertLog(
			@RequestParam(defaultValue = "") String id,
			@RequestParam(defaultValue = "") String videoId) {
		HashMap<String, String> params = new HashMap<>();
		params.put("id", id);
		params.put("videoId", videoId);

		VideoLog vl = videoLogService.selectOne(params);

		if (vl == null) {
			videoLogService.insertVideoLog(params);
			return new ResponseEntity<String>("Insert " + SUCCESS, HttpStatus.OK);
		} else {
			videoLogService.updateCnt(params);
			return new ResponseEntity<String>("viewCnt update SUCCESS", HttpStatus.OK);
		}
	}

	@GetMapping("/logList")
	public ResponseEntity<List<VideoLog>> list() {
		return new ResponseEntity<List<VideoLog>>(videoLogService.getVideoLogList(), HttpStatus.OK);
	}

	@GetMapping("/logListDesc")
	public ResponseEntity<List<VideoLog>> listDesc() {
		return new ResponseEntity<List<VideoLog>>(videoLogService.getVideoLogListDesc(), HttpStatus.OK);
	}

	@DeleteMapping("/videoLog")
	public ResponseEntity<String> deleteLog(
			@RequestParam(defaultValue = "") String id,
			@RequestParam(defaultValue = "") String videoId) {
		
		HashMap<String, String> params = new HashMap<>();
		params.put("id", id);
		params.put("videoId", videoId);
		
		videoLogService.deleteVideoLog(params);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@GetMapping("/videoLog")
	public ResponseEntity<VideoLog> getLog(
			@RequestParam(defaultValue = "") String id,
			@RequestParam(defaultValue = "") String videoId) {
		HashMap<String, String> params = new HashMap<>();
		params.put("id", id);
		params.put("videoId", videoId);
		try {
			return new ResponseEntity<VideoLog>(videoLogService.selectOne(params), HttpStatus.OK);
		} catch (Exception e) {
			throw new LogNotFoundException("시청 기록 없음");
		}
	}

	@GetMapping("/userVideoLog/{id}")
	public ResponseEntity<List<VideoLog>> getLog(@PathVariable String id) {
		try {
			return new ResponseEntity<List<VideoLog>>(videoLogService.selectOneByName(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new LogNotFoundException("시청 기록 없음");
		}
	}

}
