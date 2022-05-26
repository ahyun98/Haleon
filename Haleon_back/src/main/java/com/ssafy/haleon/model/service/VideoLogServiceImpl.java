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
	public void insertVideoLog(HashMap<String, String> params) {
		videoLogDao.insertVideoLog(params);
	}

	@Override
	public boolean deleteVideoLog(HashMap<String, String> params) {
		videoLogDao.deleteVideoLog(params);
		return true;
	}

	@Override
	public void updateCnt(HashMap<String, String> params) {
		VideoLog vl = videoLogDao.selectOne(params);
		vl.setViewCnt(vl.getViewCnt()+1);
		videoLogDao.modifyVideoLog(vl);
	}

	@Override
	public List<VideoLog> getVideoLogList() {
		return videoLogDao.selectVideoList();
	}

	@Override
	public List<VideoLog> getVideoLogListDesc() {
		return videoLogDao.selectVideoListDESC();
	}

	@Override
	public VideoLog selectOne(HashMap<String, String> params) {
		return videoLogDao.selectOne(params);
	}

	@Override
	public List<VideoLog> selectOneByName(String id) {
		return videoLogDao.selectVideoByName(id);
	}

}
