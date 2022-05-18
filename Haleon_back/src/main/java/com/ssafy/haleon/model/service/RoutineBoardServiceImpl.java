package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.model.dao.RoutineBoardDao;
import com.ssafy.haleon.model.dto.RoutineBoard;

@Service
public class RoutineBoardServiceImpl implements RoutineBoardService {

	@Autowired
	private RoutineBoardDao routineBoardDao;
	
	@Override
	public void writeBoard(RoutineBoard routineBoard) {
		routineBoardDao.insertBoard(routineBoard);
	}

	@Override
	public void modifyBoard(RoutineBoard routineBoard) {
		RoutineBoard originBoard = routineBoardDao.selectOne(routineBoard.getNo());
		originBoard.setContent(routineBoard.getContent());
		originBoard.setTitle(routineBoard.getContent());
		//저장 날짜도 변경되도록 설정함
		originBoard.setRegDate(routineBoard.getRegDate());
		
		routineBoardDao.insertBoard(originBoard);
	}

	@Override
	public void deleteBoard(int no) {
		routineBoardDao.deleteBoard(no);
	}

	@Override
	public void updateCnt(int id) {
		RoutineBoard originBoard = routineBoardDao.selectOne(id);
		originBoard.setViewCnt(originBoard.getViewCnt()+1);
	}

	@Override
	public RoutineBoard getBoardById(int id) {
		return routineBoardDao.selectOne(id);
	}

	@Override
	public RoutineBoard readBoard(int id) {
		updateCnt(routineBoardDao.selectOne(id).getNo());
		return routineBoardDao.selectOne(id);
	}

	@Override
	public List<RoutineBoard> getBoardList(HashMap<String, String> params) {
		return routineBoardDao.selectList(params);
	}

}
