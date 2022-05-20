package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.model.dao.CommunityBoardDao;
import com.ssafy.haleon.model.dto.CommunityBoard;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService {

	@Autowired
	private CommunityBoardDao communityBoardDao;
	
	@Override
	public void writeBoard(CommunityBoard communityBoard) {
		communityBoardDao.insertBoard(communityBoard);
	}

	@Override
	public void modifyBoard(CommunityBoard communityBoard) {
		CommunityBoard originBoard = communityBoardDao.selectOne(communityBoard.getNum());
		originBoard.setContent(communityBoard.getContent());
		originBoard.setTitle(communityBoard.getTitle());
		
		communityBoardDao.updateBoard(originBoard);
	}

	@Override
	public boolean deleteBoard(int id) {
		return communityBoardDao.deleteBoard(id) == 1;
	}

	@Override
	public void updateCnt(int id) {
		CommunityBoard cb = communityBoardDao.selectOne(id);
		cb.setViewCnt(cb.getViewCnt()+1);
		communityBoardDao.updateBoard(cb);
	}

	@Override
	public CommunityBoard getBoardById(int id) {
		return communityBoardDao.selectOne(id);
	}

	@Override
	public CommunityBoard readBoard(int id) {
		CommunityBoard cb = communityBoardDao.selectOne(id);
		cb.setViewCnt(cb.getViewCnt()+1);
		communityBoardDao.updateBoard(cb);
		return cb;
	}

	@Override
	public List<CommunityBoard> getBoardList(HashMap<String, String> params) {
		return communityBoardDao.selectList(params);
	}

	@Override
	public List<CommunityBoard> getBoardListDesc(HashMap<String, String> params) {
		return communityBoardDao.selectListDESC(params);
	}

}
