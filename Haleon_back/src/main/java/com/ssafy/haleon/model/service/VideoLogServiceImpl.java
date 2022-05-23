package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.model.dao.VideoLogDao;
import com.ssafy.haleon.model.dto.VideoLog;

@Service
public class VideoLogServiceImpl implements VideoLogService {
	
	@Autowired
	VideoLogDao videoLogDao;
	
	@Override
	public void insertVideoLog(VideoLog videoLog) {
		videoLogDao.insertVideoLog(videoLog);
	}

	@Override
	public boolean deleteVideoLog(int seq) {
		videoLogDao.deleteVideoLog(seq);
		return true;
	}

	@Override
	public void updateCnt(int seq) {
		VideoLog vl = videoLogDao.selectOne(seq);
		vl.setViewCnt(vl.getViewCnt()+1);
	}

	@Override
	public List<VideoLog> getVideoLogList(HashMap<String, String> params) {
		return videoLogDao.selectVideoList(params);
	}

	@Override
	public List<VideoLog> getVideoLogListDesc(HashMap<String, String> params) {
		return videoLogDao.selectVideoListDESC(params);
	}

	@Override
	public VideoLog selectOne(int seq) {
		return videoLogDao.selectOne(seq);
	}

	@Override
	public VideoLog selectOneByName(String name) {
		return videoLogDao.selectVideoByName(name);
	}

}
