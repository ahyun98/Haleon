package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.Workout;


public interface WorkoutService {
		// 운동 기록 저장
		void insertWorkout(Workout workout);

		// 운동 기록 삭제
		void deleteWorkout(HashMap<String, String> params);
		
		// 운동 기록 반환
		Workout selectOne(HashMap<String, String> params);
		
		// 모든 운동 기록 조회
		List<Workout> getWokroutList(String id);
		
		boolean isRegistered(Workout workout);
}
