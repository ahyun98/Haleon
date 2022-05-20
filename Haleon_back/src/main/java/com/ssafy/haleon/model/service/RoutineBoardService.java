package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.RoutineBoard;

public interface RoutineBoardService {
	void routineWriteBoard(RoutineBoard routineBoard);
	void routineModifyBoard(RoutineBoard routineBoard);
	boolean routineDeleteBoard(int num);
	void routineUpdateCnt(int num);
	RoutineBoard routineGetBoardById(int num);
	RoutineBoard routineReadBoard(int num);
	List<RoutineBoard> routineGetBoardList(HashMap<String, String> params);
}
