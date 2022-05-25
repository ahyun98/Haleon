package com.ssafy.haleon.model.dao;

import java.util.List;

import com.ssafy.haleon.model.dto.Workout;

public interface WorkoutDao {
	void updateWorkout(Workout workout);
	int deleteWorkout(String regDate);
	void insertWorkout(Workout workout);
	
	//게시글 읽기
	Workout selectOne(Workout workout);
	//
	Workout selectOneByIdDate(Workout workout);
	//게시글 목록 불러오기
	List<Workout> selectList(String id);
}
