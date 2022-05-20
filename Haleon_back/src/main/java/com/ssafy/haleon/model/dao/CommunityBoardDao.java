package com.ssafy.haleon.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.CommunityBoard;

public interface CommunityBoardDao {
	void updateBoard(CommunityBoard communityBoard);
	int deleteBoard(int num);
	void insertBoard(CommunityBoard communityBoard);
	
	//게시글 읽기
	CommunityBoard selectOne(int num);
	//게시글 목록 selectList
	List<CommunityBoard> selectList(HashMap<String, String> params);
}
