package com.ssafy.haleon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.haleon.model.dto.Workout;
import com.ssafy.haleon.model.service.WorkoutService;

@RestController
@RequestMapping("/api")
public class WorkoutController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	WorkoutService workoutService;

	@GetMapping("/workoutDate/{regDate}")
	public ResponseEntity<Workout> detail(@PathVariable String regDate) {
		return new ResponseEntity<Workout>(workoutService.selectOne(regDate), HttpStatus.OK);
	}

	@GetMapping("/workoutId/{id}")
	public ResponseEntity<List<Workout>> list(@PathVariable String id) {
		return new ResponseEntity<List<Workout>>(workoutService.getWokroutList(id), HttpStatus.OK);
	}

	@PostMapping("/workout")
	public ResponseEntity<String> insert(Workout workout) {
		if (workoutService.isRegistered(workout)) {
			workoutService.insertWorkout(workout);
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Modify Required", HttpStatus.OK);
	}

	@PutMapping("/workout")
	public ResponseEntity<Workout> modify(Workout workout) {
		Workout origin = workoutService.selectOne(workout.getRegDate());
		origin.setBurn(workout.getBurn());
		origin.setCal(workout.getCal());
		origin.setWorkTime(workout.getWorkTime());

		return new ResponseEntity<Workout>(origin, HttpStatus.OK);
	}

	@DeleteMapping("/workout/{regDate}")
	public ResponseEntity<String> delete(String regDate) {
		workoutService.deleteWorkout(regDate);
		return new ResponseEntity<String>("DELETION COMPELTE", HttpStatus.OK);
	}

}
