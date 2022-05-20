package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.CommunityBoard;

public interface CommunityBoardService {
		//글쓰기
		void writeBoard(CommunityBoard communityBoard);
		//글수정
		void modifyBoard(CommunityBoard communityBoard);
		//글삭제
		boolean deleteBoard(int id);
		//조회수 증가
		void updateCnt(int id);
		//글 얻어오기
		CommunityBoard getBoardById(int id);
		//글 읽기
		CommunityBoard readBoard(int id);
		//카테고리별 모든 게시물 조회
		List<CommunityBoard> getBoardList(HashMap<String, String> params);
}
