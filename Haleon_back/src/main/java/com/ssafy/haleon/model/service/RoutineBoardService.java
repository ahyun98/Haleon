package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.RoutineBoard;

public interface RoutineBoardService {
	void routineWriteBoard(RoutineBoard routineBoard);
	void routineDeleteBoard(int num);
	
	RoutineBoard routineGetBoardById(int num);
	List<RoutineBoard> routineGetBoardList(HashMap<String, String> params);
}
