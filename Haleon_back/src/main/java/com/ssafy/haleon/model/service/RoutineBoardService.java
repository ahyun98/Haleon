package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.RoutineBoard;

public interface RoutineBoardService {
	void writeBoard(RoutineBoard routineBoard);
	void modifyBoard(RoutineBoard routineBoard);
	void deleteBoard(int id);
	void updateCnt(int id);
	RoutineBoard getBoardById(int id);
	RoutineBoard readBoard(int id);
	List<RoutineBoard> getBoardList(HashMap<String, String> params);
}
