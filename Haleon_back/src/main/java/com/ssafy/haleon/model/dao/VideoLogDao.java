package com.ssafy.haleon.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.VideoLog;


public interface VideoLogDao {
	
	void insertVideoLog(VideoLog videoLog);
	void deleteVideoLog(int seq);
	VideoLog selectOne(int seq);
	
	VideoLog selectVideoByName(String username);
	//시청 기록 목록 불러오기
	List<VideoLog> selectVideoList(HashMap<String, String> params);
	//시청 기록 목록 조회수 내림차순
	List<VideoLog> selectVideoListDESC(HashMap<String, String> params);
}
