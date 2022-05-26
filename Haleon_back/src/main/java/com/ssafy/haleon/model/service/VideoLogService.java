package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.VideoLog;

public interface VideoLogService {
	// 비디오 로그 기록
	void insertVideoLog(HashMap<String, String> params);

	// 시청 기록 삭제
	boolean deleteVideoLog(HashMap<String, String> params);

	// 조회수 증가
	void updateCnt(HashMap<String, String> params);
	
	// 특정 유저의 특정 비디오 시청 기록 반환
	VideoLog selectOne(HashMap<String, String> params);
	
	// 유저의 모든 시청 기록 반환
	List<VideoLog> selectOneByName(String id);

	// 모든 비디오 로그 기록 조회
	List<VideoLog> getVideoLogList();

	// 모든 비디오 로그 기록 조회수별 조회
	List<VideoLog> getVideoLogListDesc();
}
