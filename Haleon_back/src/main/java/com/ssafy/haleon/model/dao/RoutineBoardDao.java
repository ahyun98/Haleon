package com.ssafy.haleon.model.dao;

import java.util.List;

import com.ssafy.haleon.model.dto.RoutineBoard;

public interface RoutineBoardDao {
	void routineUpdateBoard(RoutineBoard routineBoard);
	void routineInsertBoard(RoutineBoard routineBoard);
	int routineDeleteBoard(int num);
	RoutineBoard routineSelectOne(RoutineBoard routineBoard);
	List<RoutineBoard> routineSelectList(String id);
	int routineCnt(String id);
}
