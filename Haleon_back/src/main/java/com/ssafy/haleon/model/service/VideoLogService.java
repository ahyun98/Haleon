package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.VideoLog;

public interface VideoLogService {
	// 비디오 로그 기록
	void insertVideoLog(VideoLog videoLog);

	// 시청 기록 삭제
	boolean deleteVideoLog(int seq);

	// 조회수 증가
	void updateCnt(int seq);
	
	// seq에 따른 시청 기록 반환
	VideoLog selectOne(int seq);
	
	// seq에 따른 시청 기록 반환
	VideoLog selectOneByName(String name);

	// 모든 비디오 로그 기록 조회
	List<VideoLog> getVideoLogList();

	// 모든 비디오 로그 기록 조회수별 조회
	List<VideoLog> getVideoLogListDesc();
}
