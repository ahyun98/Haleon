package com.ssafy.haleon.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.model.dao.WorkoutDao;
import com.ssafy.haleon.model.dto.Workout;

@Service
public class WokroutServiceImpl implements WorkoutService {

	@Autowired
	WorkoutDao workoutDao;
	
	@Override
	public void insertWorkout(Workout workout) {
		workoutDao.insertWorkout(workout);
	}

	@Override
	public void deleteWorkout(String regDate) {
		workoutDao.deleteWorkout(regDate);
	}

	@Override
	public Workout selectOne(String regDate) {
		return workoutDao.selectOne(regDate);
	}

	@Override
	public List<Workout> getWokroutList(String id) {
		return workoutDao.selectList(id);
	}

}
