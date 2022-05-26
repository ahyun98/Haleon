package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.model.dao.WorkoutDao;
import com.ssafy.haleon.model.dto.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
	WorkoutDao workoutDao;
	
	@Override
	public void insertWorkout(Workout workout) {
		workoutDao.insertWorkout(workout);
	}

	@Override
	public void deleteWorkout(HashMap<String, String> params) {
		workoutDao.deleteWorkout(params);
	}

	@Override
	public Workout selectOne(HashMap<String, String> params) {
		return workoutDao.selectOne(params);
	}

	@Override
	public List<Workout> getWokroutList(String id) {
		return workoutDao.selectList(id);
	}

	@Override
	public boolean isRegistered(Workout workout) {
		Workout cur = workoutDao.selectOneByIdDate(workout);
		if(cur == null)
			return true;
		else
			return false;
	}

	@Override
	public void modifyWorkout(Workout workout) {
		workoutDao.updateWorkout(workout);
	}

}
