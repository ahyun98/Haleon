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
	public void routineDeleteBoard(int num) {
		routineBoardDao.routineDeleteBoard(num);
	}

	@Override
	public RoutineBoard routineGetBoard(HashMap<String, String> params) {
		return routineBoardDao.routineSelectOne(params);
	}

	@Override
	public List<RoutineBoard> routineGetBoardList(String id) {
		return routineBoardDao.routineSelectList(id);
	}

	@Override
	public void routineModifyBoard(RoutineBoard routineBoard) {
		routineBoardDao.routineUpdateBoard(routineBoard);
	}

	@Override
	public int routineCnt(String id) {
		return routineBoardDao.routineCnt(id);
	}
	
}
