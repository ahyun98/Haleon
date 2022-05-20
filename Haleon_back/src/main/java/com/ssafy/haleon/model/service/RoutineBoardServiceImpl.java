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
	public void routineWriteBoard(RoutineBoard routineBoard) {
		routineBoardDao.routineInsertBoard(routineBoard);
	}

	@Override
	public void routineModifyBoard(RoutineBoard routineBoard) {
		RoutineBoard originBoard = routineBoardDao.routineSelectOne(routineBoard.getNum());
		originBoard.setContent(routineBoard.getContent());
		originBoard.setTitle(routineBoard.getContent());
		//저장 날짜도 변경되도록 설정함
		originBoard.setRegDate(routineBoard.getRegDate());
		
		routineBoardDao.routineInsertBoard(originBoard);
	}

	@Override
	public boolean routineDeleteBoard(int num) {
		return routineBoardDao.routineDeleteBoard(num) == 1; 
	}

	@Override
	public void routineUpdateCnt(int num) {
		RoutineBoard originBoard = routineBoardDao.routineSelectOne(num);
		originBoard.setViewCnt(originBoard.getViewCnt()+1);
	}

	@Override
	public RoutineBoard routineGetBoardById(int num) {
		return routineBoardDao.routineSelectOne(num);
	}

	@Override
	public RoutineBoard routineReadBoard(int num) {
		routineUpdateCnt(routineBoardDao.routineSelectOne(num).getNum());
		return routineBoardDao.routineSelectOne(num);
	}

	@Override
	public List<RoutineBoard> routineGetBoardList(HashMap<String, String> params) {
		return routineBoardDao.routineSelectList(params);
	}

}
