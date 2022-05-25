package com.ssafy.haleon.model.service;

import java.util.List;

import com.ssafy.haleon.model.dto.RoutineBoard;

public interface RoutineBoardService {
	void routineWriteBoard(RoutineBoard routineBoard);
	void routineDeleteBoard(int num);
	void routineModifyBoard(RoutineBoard routineBoard);
	RoutineBoard routineGetBoard(RoutineBoard routineBoard);
	List<RoutineBoard> routineGetBoardList(String id);
	int routineCnt(String id);
}
