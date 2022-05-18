package com.ssafy.haleon.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.RoutineBoard;

public interface RoutineBoardDao {
	void updateBoard(RoutineBoard routineBoard);
	void insertBoard(RoutineBoard routineBoard);
	void deleteBoard(int no);
	RoutineBoard selectOne(int no);
	List<RoutineBoard> selectList(HashMap<String, String> params);
}
