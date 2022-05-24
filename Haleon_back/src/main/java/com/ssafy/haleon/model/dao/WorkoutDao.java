package com.ssafy.haleon.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.Workout;

public interface WorkoutDao {
	void updateWorkout(Workout workout);
	int deleteWorkout(String regDate);
	void insertWorkout(Workout workout);
	
	//게시글 읽기
	Workout selectOne(String regDate);
	//게시글 목록 불러오기
	List<Workout> selectList(HashMap<String, String> params);
}