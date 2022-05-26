package com.ssafy.haleon.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.VideoLog;


public interface VideoLogDao {
	
	void insertVideoLog(HashMap<String, String> params);
	void modifyVideoLog(VideoLog videoLog);
	VideoLog selectOne(HashMap<String, String> params);
	void deleteVideoLog(HashMap<String, String> params);
	
	List<VideoLog> selectVideoByName(String id);
	//시청 기록 목록 불러오기
	List<VideoLog> selectVideoList();
	//시청 기록 목록 조회수 내림차순
	List<VideoLog> selectVideoListDESC();
}
